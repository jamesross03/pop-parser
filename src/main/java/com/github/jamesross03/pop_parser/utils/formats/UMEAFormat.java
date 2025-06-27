package com.github.jamesross03.pop_parser.utils.formats;

import java.util.Map;

import com.github.jamesross03.pop_parser.utils.RecordFormat;

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
