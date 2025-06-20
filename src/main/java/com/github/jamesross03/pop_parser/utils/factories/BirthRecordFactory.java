package com.github.jamesross03.pop_parser.utils.factories;

import java.util.Map;

import com.github.jamesross03.pop_parser.utils.RecordFactory;
import com.github.jamesross03.pop_parser.utils.RecordFormat;
import com.github.jamesross03.pop_parser.utils.records.BirthRecord;

/**
 * Implementation of IRecordFactory interface for creating BirthRecords from
 * lines of CSV input.
 */
public class BirthRecordFactory extends RecordFactory<BirthRecord> {
    public BirthRecordFactory(RecordFormat format) {
        super(format);
    }

    public BirthRecord makeRecord(Map<String, String> entry) {
        return new BirthRecord(
            format.getForenameBirth(entry),
            format.getSurnameBirth(entry)
        );
    }
}
