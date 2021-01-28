package dietApp.dietapp.food.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import dietApp.dietapp.client.FoodApiService;
import dietApp.dietapp.exception.FoodNotExistException;
import dietApp.dietapp.food.dto.Food;
import lombok.RequiredArgsConstructor;


import org.springframework.stereotype.Service;

import static dietApp.dietapp.food.validate.FoodValidation.isFoodExist;

@Service
@RequiredArgsConstructor
public class FoodService{

    private final FoodApiService foodApiService;

    public Food searchFood(String foodName) throws JsonProcessingException, FoodNotExistException {
        Food food = foodApiService.mapClientToFood(foodName);
        if (isFoodExist(food)){
            return food;
        } else throw new FoodNotExistException(foodName);
    }

}
