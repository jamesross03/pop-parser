package com.github.jamesross03.pop_parser.utils;

import java.util.Map;

/**
 * Abstract class representing a format of record input.
 */
public abstract class RecordFormat {
    // ----- Birth records -----
    /**
     * Gets forename from a birth record.
     * 
     * @param row Map of &lt;key, value&gt; pairs from a line of input
     * @return forename
     */
    public abstract String getForenameBirth(Map<String, String> row);

    /**
     * Gets surname from a birth record.
     * 
     * @param row Map of &lt;key, value&gt; pairs from a line of input
     * @return surname
     */
    public abstract String getSurnameBirth(Map<String, String> row);
}
