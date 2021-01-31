package dietApp.dietapp.mapper;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

@RequiredArgsConstructor
@Getter
public class CustomJsonNode {

    @Autowired
    private ApplicationCustomMapper mapper;

    private JsonNode node;

    public CustomJsonNode(JsonNode node) {
        this.node = node;
    }

    public CustomJsonNode get(String string) throws JsonProcessingException {
        if (node.get(string) == null)
            return new CustomJsonNode(mapper.parse("{ \""+string+"\": 0.0 }"));
        else return new CustomJsonNode(node.get(string));
    }

    public float asFloat(){
      return getNode().floatValue();
    }


}
