package com.github.jamesross03.pop_parser.utils;

import java.util.Map;

import com.github.jamesross03.pop_parser.Constants;

/**
 * Factory class for making Record objects from a line of CSV input. 
 */
public class RecordFactory {
    //TODO: Make this an astract class and make different implementations for different record types
    private final String format;
    private final String type;

    /**
     * @param config Config object (defines record format and type)
     */
    public RecordFactory(String format, String type) {
        this.format = format;
        this.type = type;
    }

    /**
     * @param entry Map of <header, value> pairs
     * @return generated Record
     */
    public Record makeRecord(Map<String, String> entry) {
        return switch(format) {
            case Constants.TD -> switch(type) {
                case Constants.BIRTH -> new Record(
                    entry.get("child's forname(s)"),
                    entry.get("child's surname")
                );
                default -> null;
            };
            default -> null;
        } ;
    }
}
