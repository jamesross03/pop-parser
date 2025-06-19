package com.github.jamesross03.pop_parser.utils;

import java.util.Map;

/**
 * Interface for generic factory class for making Record objects from a line of
 * CSV input. 
 */
public interface IRecordFactory<T> {
    /**
     * @param entry Map of <header, value> pairs
     * @return generated <T>
     */
    public T makeRecord(Map<String, String> entry);
}
