package com.github.jamesross03.pop_parser.utils;

import java.util.Map;

/**
 * Abstract factory class for making objects of Record subclass {@code T} from a
 * line of CSV input. 
 * 
 * @param <T> subclass of Record abstract class
 */
public abstract class RecordFactory<T extends Record> {
    /**
     * Structure of records being input.
     */
    protected final RecordFormat format;

    /**
     * Instialises a new instance of a RecordFactory subclass for use with a
     * given RecordFormat 
     * 
     * @param format record format to use
     */
    public RecordFactory(RecordFormat format) {
        this.format = format;
    }
    
    /**
     * Takes a map of attribute names and their corresponding values,
     * representing a line read in from a record file, and uses them to create a
     * new Record object of subclass T.
     * 
     * @param entry Map of &lt;key, value&gt; pairs from a line of input
     * @return generated instance of Record subclass
     */
    public abstract T makeRecord(Map<String, String> entry);
}
