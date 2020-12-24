package utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.HashMap;

public class SerialUtils {
    private static ObjectMapper objectMapper = new ObjectMapper();
    public static String toJSONString(Object object) throws JsonProcessingException {
        String jsonString = objectMapper.writerWithDefaultPrettyPrinter()
                .writeValueAsString(object);
        return jsonString;
    }

    public static String getSuccessResult() throws JsonProcessingException {
        HashMap<String,String> map = new HashMap<String, String>();
        map.put("result","success");
        String jsonString = objectMapper.writerWithDefaultPrettyPrinter()
                .writeValueAsString(map);
        return jsonString;
    }

    public static String getErrorResult() throws JsonProcessingException {
        HashMap<String,String> map = new HashMap<String, String>();
        map.put("result","error");
        String jsonString = objectMapper.writerWithDefaultPrettyPrinter()
                .writeValueAsString(map);
        return jsonString;
    }
}
