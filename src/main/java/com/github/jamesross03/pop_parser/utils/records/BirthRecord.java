package com.github.jamesross03.pop_parser.utils.records;

/**
 * Object representing a Birth Record.
 */
public class BirthRecord {
    private final String forename;
    private final String surname;

    public BirthRecord(String forename, String surname) {
        this.forename = forename;
        this.surname = surname;
    }

    public String getForename() {
        return this.forename;
    }

    public String getSurname() {
        return this.surname;
    }
}
