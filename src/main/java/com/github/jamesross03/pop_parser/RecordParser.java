package com.github.jamesross03.pop_parser;

import com.github.jamesross03.pop_parser.utils.RecordFactory;
import com.github.jamesross03.pop_parser.utils.RecordFormat;
import com.github.jamesross03.pop_parser.utils.Record;
import com.opencsv.CSVParser;
import com.opencsv.exceptions.CsvValidationException;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

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
    public List<T> parse(String filepath) throws IOException, CsvValidationException {
        try (Stream<String> stream = Files.lines(Path.of(filepath))) {
            return parse(stream);
        }
    }
    
    /**
     * Parses all lines from an input stream of CSV data (with headers) into
     * objects of {@code Record} subclass {@code T}.
     * 
     * @param csvStream input stream of CSV data (incl. headers)
     * @return list containing the parsed {@code T} objects
     * @throws IOException if errors occur during file-reading
     * @throws CsvValidationException if CSV is invalid or incorrectly formatted
     */
    public List<T> parse(Stream<String> csvStream) throws IOException, CsvValidationException {
        List<T> results = new ArrayList<>();
        Iterator<String> lines = csvStream.iterator();
        CSVParser parser = new CSVParser();

        // Handle empty streams
        if (!lines.hasNext()) return Collections.emptyList();

        // Get headers
        String[] headers = parser.parseLine(lines.next());

        // Iterate for all lines of values
        String[] values;
        Map<String, String> row;
        T r;
        while (lines.hasNext()) {
            if ((values = parser.parseLine(lines.next())) == null) continue;

            if (headers.length != values.length) {
                throw new CsvValidationException("Inconsistent number of columns, see line " + results.size()+2);
            }

            // Make map of headers to values
            row = new LinkedHashMap<>();
            for (int i = 0; i < headers.length; i++) {
                row.put(headers[i], values[i]);
            }

            // Make record
            if ((r = rf.makeRecord(row)) != null) {
                results.add(r);
            }
        }

        return results;
    }
}