package com.github.jamesross03.pop_parser.utils.formats;

import java.util.Map;

import com.github.jamesross03.pop_parser.utils.RecordFormat;

/**
 * Class representing the UMEA format of record input, as used in the UMEA
 * Swedish populations dataset.
 */
public class UMEAFormat extends RecordFormat {

    @Override
    public String getForenameBirth(Map<String, String> row) {
        return row.get("FORENAME");
    }

    @Override
    public String getSurnameBirth(Map<String, String> row) {
        return row.get("SURNAME");
    }
    
}
