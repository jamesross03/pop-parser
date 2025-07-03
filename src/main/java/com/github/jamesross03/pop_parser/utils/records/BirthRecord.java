package com.github.jamesross03.pop_parser.utils.records;

import com.github.jamesross03.pop_parser.utils.Record;

/**
 * Object representing a birth record.
 */
public class BirthRecord extends Record {
    /**
     * Forename of data-subject.
     */
    private final String forename;
    /**
     * Surname of data-subject.
     */
    private final String surname;

    /**
     * Initialises a new instance of the {@code BirthRecord} class for the given
     * attributes.
     * 
     * @param forename forename of data-subject
     * @param surname surname of data-subject
     */
    public BirthRecord(String forename, String surname) {
        this.forename = forename;
        this.surname = surname;
    }

    /**
     * Gets forename of data-subject.
     * 
     * @return forename
     */
    public String getForename() {
        return this.forename;
    }

    /**
     * Gets surname of data-subject.
     * 
     * @return surname
     */
    public String getSurname() {
        return this.surname;
    }

    @Override
    public String toString() {
        return "Birth record";
    }
}
