package dietApp.dietapp.mapper;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ApplicationCustomMapper {

    private static ObjectMapper objectMapper = getApiMapper();

    private static ObjectMapper getApiMapper(){
        ObjectMapper apiMapper = new ObjectMapper();
        apiMapper.configure(DeserializationFeature.FAIL_ON_NULL_CREATOR_PROPERTIES,false);
        return  apiMapper;
    }

    public static JsonNode toJson(Object o){
        return  objectMapper.valueToTree(o);
    }

    public static JsonNode parse(String src) throws JsonProcessingException {
        return objectMapper.readTree(src);
    }

}
