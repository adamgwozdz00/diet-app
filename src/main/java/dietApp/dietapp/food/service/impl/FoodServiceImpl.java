package dietApp.dietapp.food.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import dietApp.dietapp.client.FoodApiService;
import dietApp.dietapp.food.service.FoodService;
import dietApp.dietapp.food.dto.Food;
import lombok.RequiredArgsConstructor;


import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FoodServiceImpl implements FoodService{

    private final FoodApiService foodApiService;

    @Override
    public Food searchFood(String foodName) throws JsonProcessingException {
        return foodApiService.mapClientToFood(foodName);
    }

}
