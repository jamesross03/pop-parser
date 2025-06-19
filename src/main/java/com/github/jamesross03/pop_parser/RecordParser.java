package com.github.jamesross03.pop_parser;

import com.github.jamesross03.pop_parser.utils.Record;
import com.github.jamesross03.pop_parser.utils.RecordFactory;

import com.opencsv.CSVReaderHeaderAware;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Parser for record input files.
 */
public class RecordParser {
    private final String format;
    private final String type;
    private final RecordFactory rf;

    public RecordParser(String format, String type) {
        this.format = format;
        this.type = type;
        this.rf = new RecordFactory(format, type);
    }

    /**
     * Reads all lines from an input file into objects.
     * 
     * @param filepath 
     * @return List of Records
     * @throws IOException
     * @throws CsvValidationException
     */
    public List<Record> getAllLines(String filepath) throws IOException, CsvValidationException {
        List<Record> list = new ArrayList<>();

        try (CSVReaderHeaderAware reader = new CSVReaderHeaderAware(new FileReader(filepath))) {
            Map<String, String> values;

            while ((values = reader.readMap()) != null) {
                Record r =  rf.makeRecord(values);
                if (r != null) list.add(r);
            }

        }

        return list;
    }
}