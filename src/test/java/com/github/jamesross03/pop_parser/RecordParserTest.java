package com.github.jamesross03.pop_parser;

import static org.junit.jupiter.api.Assertions.*;

import java.net.URL;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.github.jamesross03.pop_parser.utils.RecordFormat;
import com.github.jamesross03.pop_parser.utils.formats.*;
import com.github.jamesross03.pop_parser.utils.records.*;

public class RecordParserTest {
    private static final RecordFormat TD = new TDFormat();

    /**
     * @param path Relative path (from resources) to test CSV file
     * @param type Record type <T> being parsed
     * @param format RecordFormat corresponding to file contents
     */
    private <T> void testParsing(String path, Class type, RecordFormat format) {
        try {
            URL filepath = getClass().getClassLoader().getResource(path);
            assertNotNull(filepath, "Failed to load test-data at `" + path +"`");

            RecordParser<T> parser = new RecordParser<>(type, format);
            List<T> records = parser.parse(filepath.getPath());

            assertNotNull(records, "Records list shouldn't be null");
            assertFalse(records.isEmpty(), "Records list should not be be empty");
        } catch (Exception e) {
            fail("Parsing threw an exception: " + e.getMessage());
        }
    }

    @Test
    public void testParseTDBirthRecords() {
        testParsing("inputs/TD_300/birth_records.csv",BirthRecord.class, TD);
    }
}
