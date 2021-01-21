package dietApp.dietapp.food.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import dietApp.dietapp.food.dto.Food;

public interface FoodService {

    Food searchFood(String foodName) throws JsonProcessingException;
}
