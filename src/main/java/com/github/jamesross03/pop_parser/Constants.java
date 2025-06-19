package com.github.jamesross03.pop_parser;

import java.util.Map;

import com.github.jamesross03.pop_parser.utils.IRecordFactory;
import com.github.jamesross03.pop_parser.utils.factories.*;
import com.github.jamesross03.pop_parser.utils.records.*;

/**
 * Defines constants used in the library
 */
public class Constants {
    /**
     * Map of pairs of Record classes and their corresponding factories.
     */
    public static final Map<Class<?>, IRecordFactory<?>> FACTORY_MAP = Map.of(
        BirthRecord.class, new BirthRecordFactory()
    );
}
