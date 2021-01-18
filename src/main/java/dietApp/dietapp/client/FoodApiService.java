package dietApp.dietapp.client;

import com.fasterxml.jackson.core.JsonProcessingException;

import com.fasterxml.jackson.databind.JsonNode;
import dietApp.dietapp.client.FoodApiClient;
import dietApp.dietapp.mapper.ApplicationCustomMapper;
import dietApp.dietapp.mapper.CustomJsonNode;
import dietApp.dietapp.model.Food;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;


@Component
@RequiredArgsConstructor
public class FoodApiService {

    private final FoodApiClient client;
    private ApplicationCustomMapper mapper;

    public Food mapClientToFood(String name) throws JsonProcessingException {
        CustomJsonNode node = new CustomJsonNode(mapper.toJson(client.getFoodAsString(name)));

        return new Food(
                name,
                node.get("totalWeight").asFloat(),
                node.get("totalNutrients").get("ENERC_KCAL").get("quantity").asFloat(),
                node.get("totalNutrients").get("PROCNT").get("quantity").asFloat(),
                node.get("totalNutrients").get("FAT").get("quantity").asFloat(),
                node.get("totalNutrients").get("CHOCDF").get("quantity").asFloat(),
                node.get("totalNutrients").get("SUGAR").get("quantity").asFloat()
        );





    }

}
