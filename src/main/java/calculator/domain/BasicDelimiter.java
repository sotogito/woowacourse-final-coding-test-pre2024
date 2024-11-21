package calculator.domain;

import java.util.ArrayList;
import java.util.List;

public enum BasicDelimiter {
    COMMA(","),
    COLON(":");

    private final String delimiter;

    BasicDelimiter(String delimiter) {
        this.delimiter = delimiter;
    }

    public String get() {
        return delimiter;
    }

    public static List<String> getAll() {
        List<String> result = new ArrayList<>();
        for (BasicDelimiter basicDelimiter : BasicDelimiter.values()) {
            result.add(basicDelimiter.get());
        }
        return result;
    }

}
