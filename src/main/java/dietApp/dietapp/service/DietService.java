package dietApp.dietapp.service;

import dietApp.dietapp.model.Diet;
import dietApp.dietapp.model.DishType;
import dietApp.dietapp.repository.DietRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;


@Service
@RequiredArgsConstructor
public class DietService {

    private final DietRepository dietRepository;
    Date date = new Date();


    public Diet addFoodToDiet(Long userId, DishType dishType,String foodName){

        Diet diet = new Diet();
        diet.setUserId(userId);
        diet.setDishType(dishType);
        diet.setFood(foodName);
        diet.setDate(date);

        return dietRepository.save(diet);
    }

//    public void DeleteFood()

}
