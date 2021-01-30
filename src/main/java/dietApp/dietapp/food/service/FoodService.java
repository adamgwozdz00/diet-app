package dietApp.dietapp.food.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import dietApp.dietapp.client.FoodApiService;
import dietApp.dietapp.exception.FoodNotExistException;
import dietApp.dietapp.food.dto.Food;
import lombok.RequiredArgsConstructor;


import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class FoodService{

    private final FoodApiService foodApiService;

    public Food searchFood(String foodName) {
        try {
            Food food = foodApiService.mapClientToFood(foodName);
            return food;
        } catch (JsonProcessingException | FoodNotExistException e){
            System.out.println(e.getMessage());
        }
        return null;
    }

}
