package com.github.jamesross03.pop_parser.utils;


/**
 * Abstract class representing a record. Doesn't define any variables or
 * functions but provides type-safety for typed classes.
 */
public abstract class Record {
    // See above.

    @Override
    /**
     * Gets human-readable String representation of Record
     * 
     * @return name of record type
     */
    public abstract String toString();
}
