package com.github.jamesross03.pop_parser;

import java.util.Map;
import java.util.function.Function;

import com.github.jamesross03.pop_parser.utils.RecordFactory;
import com.github.jamesross03.pop_parser.utils.RecordFormat;
import com.github.jamesross03.pop_parser.utils.Record;
import com.github.jamesross03.pop_parser.utils.factories.*;
import com.github.jamesross03.pop_parser.utils.records.*;

/**
 * Defines constants used in the pop-parser library.
 */
public class Constants {
    /**
     * Map of &lt;{@code Record} subclass, {@link RecordFactory} subclass
     * instance&gt; pairs used to get corresponding factory.
     */
    public static final Map<Class<? extends Record>, Function<RecordFormat, RecordFactory<? extends Record>>> FACTORY_MAP = Map.of(
        BirthRecord.class, BirthRecordFactory::new
    );
}
