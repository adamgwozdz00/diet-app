package dietApp.dietapp.diet.service;

import dietApp.dietapp.food.dto.Food;
import dietApp.dietapp.diet.entity.Diet;
import dietApp.dietapp.diet.entity.DishType;

import java.util.List;

public interface DietService {

    Diet addFoodToDiet(String username, DishType dishType, Food food);
    void deleteFood(Long id);
    List<Diet> getUserDiet(String username, String date);
}
