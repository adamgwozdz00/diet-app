package dietApp.dietapp.service;

import dietApp.dietapp.client.dto.Food;
import dietApp.dietapp.config.CurrentDateAsString;
import dietApp.dietapp.model.Diet;
import dietApp.dietapp.model.DishType;
import dietApp.dietapp.repository.DietRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class DietService {

    private final DietRepository dietRepository;
    private String date = CurrentDateAsString.getTodayDate();


    public Diet addFoodToDiet(String username,
                              DishType dishType,
                              String foodName,
                              float weight,
                              float calories,
                              float carbohydrates,
                              float fat,
                              float protein,
                              float sugar){

        return dietRepository.save(new Diet(
                username,dishType,foodName,weight,calories,carbohydrates,fat,protein,sugar,date
        ));
    }



    public void deleteFood(Long id){
        dietRepository.deleteById(id);
    }

    public List<Diet> getUserDiet(String username, String date){
        return dietRepository.findAllByUserAndDate(username,date);
    }




}
