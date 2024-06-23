package hexlet.code;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Map;

public class Parser {

    public static Map<String, Object> parse(String content, String format) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        Map<String, Object> map = objectMapper.readValue(content, new TypeReference<Map<String,Object>>(){});
        return map;
    }
}
