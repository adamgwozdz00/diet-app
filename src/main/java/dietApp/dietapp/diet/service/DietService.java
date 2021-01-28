package dietApp.dietapp.diet.service;

import dietApp.dietapp.diet.dto.NutritionValuesDto;
import dietApp.dietapp.food.dto.Food;
import dietApp.dietapp.CurrentDateAsString;
import dietApp.dietapp.diet.entity.Diet;
import dietApp.dietapp.diet.entity.DishType;
import dietApp.dietapp.diet.repository.DietRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class DietService{

    private final DietRepository dietRepository;
    private String date = CurrentDateAsString.getTodayDate();

    public Diet addFoodToDiet(String username,
                              DishType dishType,
                              Food food){

        return dietRepository.save(Diet.builder()
                .user(username)
                .date(date)
                .dishType(dishType)
                .food(food.getName())
                .weight(food.getWeight())
                .calories(food.getCalories())
                .protein(food.getProtein())
                .fat(food.getFat())
                .carbohydrates(food.getCarbohydrates())
                .sugar(food.getSugar())
                .build()
        );
    }

    public void deleteFood(Long id){
        dietRepository.deleteById(id);
    }

    public List<Diet> getUserDiet(String username, String date){
        return dietRepository.findAllByUserAndDate(username,date);
    }

    public NutritionValuesDto getUserTotalNutritionValues(String username, String date) {
        try {
            return dietRepository.getTotalNutritionValues(username, date).orElseThrow();
        } catch (Exception e){
            e.getMessage();
        }
        return null;
    }
}
