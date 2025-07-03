# pop-parser
A modular and reusable Java library containing functionality for parsing population record CSVs.

This library exists as a proof-of-concept and currently offers **limited functionality**:
- Only limited BirthRecord support for Record types
  - Currently only parses forename and surname 
- Supports TD and UMEA record formats.

For in-depth documentation, see the [JavaDocs](https://jamesross03.github.io/pop-parser/).

## Basic usage example
The pop-parser library allows you to read CSV files in a pre-defined record structure into a List of Record objects. A basic example of this for birth records in TD format is seen below:

```java
import com.github.jamesross03.pop_parser.RecordParser;
import com.github.jamesross03.pop_parser.utils.records.BirthRecord;
import com.github.jamesross03.pop_parser.utils.formats.TDFormat;
import com.github.jamesross03.pop_parser.utils.RecordFormat;

RecordFormat format = new TDFormat();
RecordParser<BirthRecord> parser = new RecordParser<>(BirthRecord.class, format);
List<BirthRecord> records = parser.parse(filepath);
```

The parse function can also take any `Stream<String>` as a parameter, if your use-case doesn't involve a local file.

## Adding to your project
The pop-parser library is available as a Maven package through Github Packages and can be added to your project using the following dependency:
```
<repositories>
  <repository>
    <id>github</id>
    <url>https://maven.pkg.github.com/jamesross03/pop-parser</url>
  </repository>
</repositories>

<dependencies>
  <dependency>
    <groupId>com.github.jamesross03</groupId> 
    <artifactId>pop-parser</artifactId>
    <version>1.2.6-alpha</version>
  </dependency>
</dependencies>
```
