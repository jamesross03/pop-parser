package com.github.jamesross03.pop_parser;

import com.github.jamesross03.pop_parser.utils.RecordFactory;
import com.github.jamesross03.pop_parser.utils.RecordFormat;
import com.github.jamesross03.pop_parser.utils.Record;
import com.opencsv.CSVReaderHeaderAware;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Parser for CSV files containing Records, where <T> is the Record class
 * (e.g BirthRecord).
 */
public class RecordParser<T extends Record> {
    /**
     * Record Factory implementation used to create records from line in CSV.
     */
    private final RecordFactory<T> rf;

    /**
     * Creates a new instance of the RecordParser class for <T> records.
     * 
     * @param type Record type <T> being parsed
     * @param format RecordFormat corresponding to file contents
     */
    @SuppressWarnings("unchecked")
    public RecordParser(Class<T> type, RecordFormat format) {
        // Gets generic recordFactory corresponding to type <T>
        var constructor = Constants.FACTORY_MAP.get(type);

        if (constructor == null) {
            throw new IllegalArgumentException("Invalid record type: " + type.getSimpleName());
        }

        // Cast to correct type
        this.rf = (RecordFactory<T>)constructor.apply(format);
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