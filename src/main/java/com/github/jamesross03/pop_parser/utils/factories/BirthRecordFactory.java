package com.github.jamesross03.pop_parser.utils.factories;

import java.util.Map;

import com.github.jamesross03.pop_parser.utils.IRecordFactory;
import com.github.jamesross03.pop_parser.utils.records.BirthRecord;

/**
 * Implementation of IRecordFactory interface for creating BirthRecords from
 * lines of CSV input.
 */
public class BirthRecordFactory implements IRecordFactory<BirthRecord> {
    public BirthRecord makeRecord(Map<String, String> entry) {
        return new BirthRecord(
            entry.get("child's forname(s)"),
            entry.get("child's surname")
        );
    }
}
