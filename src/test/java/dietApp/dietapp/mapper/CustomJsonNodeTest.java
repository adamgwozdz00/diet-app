package dietApp.dietapp.mapper;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CustomJsonNodeTest {

    private static String src = "{ \"title\":\"title\", \"author\":\"author\" }";
    ApplicationCustomMapper mapper;


    @Test
    void shouldReturnJsonCorrectJsonNode() throws JsonProcessingException {
        //given
        JsonNode testNode = mapper.parse("{\"age\":0.0 }");
        CustomJsonNode node = new CustomJsonNode(mapper.parse(src));
        //when
        //then
        assertEquals(testNode.get("age").floatValue(),node.get("age").asFloat());
    }

}