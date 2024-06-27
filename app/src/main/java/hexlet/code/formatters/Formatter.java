package hexlet.code.formatters;

import com.fasterxml.jackson.core.JsonProcessingException;

import java.util.List;
import java.util.Map;

public class Formatter {
    public static String format(List<Map<String, Object>> compareResult, String format) throws JsonProcessingException {
        return switch (format) {
            case "stylish" -> StylishFormatter.format(compareResult);
            case "plain" -> PlainFormatter.format(compareResult);
            case "json" -> JSONFormatter.format(compareResult);
            default -> throw new RuntimeException("format not supported");
        };
    }
}
