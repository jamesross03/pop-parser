package com.github.jamesross03.pop_parser;

import java.util.Map;

import com.github.jamesross03.pop_parser.utils.*;
import com.github.jamesross03.pop_parser.utils.records.*;

/**
 * Defines constants used in the library
 */
public class Constants {
    // ---- Record formats ---- 
    public static final String TD = "TD";
    /** List of permitted record formats */
    public static final String[] FORMATS = new String[]{TD};

    // ---- Record types ----
    public static final String BIRTH = "BIRTH";
    /** List of permitted record types */
    public static final String[] TYPES = new String[]{BIRTH};

    public static final Map<Class<?>, IRecordFactory<?>> FACTORY_MAP = Map.of(
        BirthRecord.class, new BirthRecordFactory()
    );
}
