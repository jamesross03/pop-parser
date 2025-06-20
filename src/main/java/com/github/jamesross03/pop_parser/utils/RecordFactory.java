package com.github.jamesross03.pop_parser.utils;

import java.util.Map;

/**
 * Abstract factory class for making record <T> objects from a line of CSV 
 * input. 
 */
public abstract class RecordFactory<T> {
    protected final RecordFormat format;

    /**
     * Creates a new instance of a RecordFactory subclass for a given
     * RecordFormat 
     * 
     * @param format format to use
     */
    public RecordFactory(RecordFormat format) {
        this.format = format;
    }
    
    /**
     * @param entry Map of <header, value> pairs
     * @return generated <T>
     */
    public abstract T makeRecord(Map<String, String> entry);
}
