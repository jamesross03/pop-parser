package com.github.jamesross03.pop_parser.utils.formats;

import java.util.Map;

import com.github.jamesross03.pop_parser.utils.RecordFormat;

public class TDFormat extends RecordFormat {

    @Override
    public String getForenameBirth(Map<String, String> row) {
        return row.get("child's forname(s)");
    }

    @Override
    public String getSurnameBirth(Map<String, String> row) {
        return row.get("child's surname");
    }
    
}
