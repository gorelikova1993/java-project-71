package hexlet.code;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

import java.io.IOException;

import java.util.Map;

public class Parser {

    public static Map<String, Object> parse(String content, String format)
            throws IOException {
        switch (format) {
            case "json":
                ObjectMapper objectMapper = new ObjectMapper();
                return objectMapper.readValue(content, new TypeReference<>() {
                });
            case "yaml", "yml":
                ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
                return mapper.readValue(content, Map.class);
            default:
                throw new RuntimeException("format not supported");
        }
    }
}
