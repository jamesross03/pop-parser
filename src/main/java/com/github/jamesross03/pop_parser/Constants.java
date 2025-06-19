package com.github.jamesross03.pop_parser;

import java.util.Map;
import java.util.function.Function;

import com.github.jamesross03.pop_parser.utils.RecordFactory;
import com.github.jamesross03.pop_parser.utils.RecordFormat;
import com.github.jamesross03.pop_parser.utils.factories.*;
import com.github.jamesross03.pop_parser.utils.records.*;

/**
 * Defines constants used in the library
 */
public class Constants {
    /**
     * Map of pairs of Record classes and their corresponding factories.
     */
    public static final Map<Class<?>, Function<RecordFormat, RecordFactory<?>>> FACTORY_MAP = Map.of(
        BirthRecord.class, BirthRecordFactory::new
    );
}
