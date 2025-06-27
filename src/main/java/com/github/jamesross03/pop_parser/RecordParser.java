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
 * Parser for CSV input files containing records, where type {@code T} is a
 * subclass of the {@code Record} abstract class representing the type of
 * records (e.g birth).
 * 
 * @param <T> subclass of {@code Record} to be parsed
 */
public class RecordParser<T extends Record> {
    /**
     * {@link RecordFactory} instance used to create {@code T}  objects from input.
     */
    private final RecordFactory<T> rf;

    /**
     * Initialises a new instance of {@code RecordParser} for parsing records of
     * type {@code T} from input in a given format.
     * 
     * @param type class of {@code Record} subclass to parse
     * @param format format of input
     */
    @SuppressWarnings("unchecked")
    public RecordParser(Class<T> type, RecordFormat format) {
        // Gets RecordFactory instance corresponding to <T>
        var constructor = Constants.FACTORY_MAP.get(type);

        if (constructor == null) {
            throw new IllegalArgumentException("Invalid record type: " + type.getSimpleName());
        }

        // Cast to correct type
        this.rf = (RecordFactory<T>)constructor.apply(format);
    }

    /**
     * Parses all lines from an input file into objects of {@code Record} subclass {@code T}
     * 
     * @param filepath filepath of input CSV
     * @return list containing the parsed {@code T} objects
     * @throws IOException if errors occur during file-reading
     * @throws CsvValidationException if CSV is invalid or incorrectly formatted
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