package com.github.jamesross03.pop_parser;

import com.github.jamesross03.pop_parser.utils.IRecordFactory;

import com.opencsv.CSVReaderHeaderAware;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Parser for record input files.
 */
// TODO: For now, hardcode TD format
public class RecordParser<T> {
    private final IRecordFactory<T> rf;

    @SuppressWarnings("unchecked")
    public RecordParser(Class<T> type) {
        IRecordFactory<?> factory = Constants.FACTORY_MAP.get(type);

        if (factory == null) {
            throw new IllegalArgumentException("Invalid record type: " + type.getSimpleName());
        }

        rf = (IRecordFactory<T>)(factory);
    }

    /**
     * Reads all lines from an input file into <T> record objects.
     * 
     * @param filepath 
     * @return List of <T> record objects
     * @throws IOException
     * @throws CsvValidationException
     */
    public List<T> parse (String filepath) throws IOException, CsvValidationException {
        List<T> list = new ArrayList<T>();

        try (CSVReaderHeaderAware reader = new CSVReaderHeaderAware(new FileReader(filepath))) {
            Map<String, String> values;
            T r;
            while ((values = reader.readMap()) != null) {
                if ((r =  rf.makeRecord(values)) != null) list.add(r);
            }

        }

        return list;
    }
}