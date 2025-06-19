package com.github.jamesross03.pop_parser.utils;

import java.util.Map;

/**
 * Abstract class representing a RecordFormat
 */
public abstract class RecordFormat {
    // Birth records
    public abstract String getForenameBirth(Map<String, String> row);
    public abstract String getSurnameBirth(Map<String, String> row);
}
