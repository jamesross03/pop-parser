package com.github.jamesross03.pop_parser.utils.formats;

import java.util.Map;

import com.github.jamesross03.pop_parser.utils.RecordFormat;

/**
 * Class representing the TD format of record input, as designed by Tom Dalton
 * (https://github.com/tomsdalton) and generated using the Valipop application
 * (https://github.com/stacs-srg/valipop).
 */
public class TDFormat extends RecordFormat {

    @Override
    public String getForenameBirth(Map<String, String> row) {
        return row.get("child's forname(s)");
    }

    @Override
    public String getSurnameBirth(Map<String, String> row) {
        return row.get("child's surname");
    }

    @Override
    public String toString() {
        return "TD format";
    }
    
}
