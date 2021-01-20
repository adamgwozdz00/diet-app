package dietApp.dietapp.service;

import dietApp.dietapp.model.Diet;
import dietApp.dietapp.model.DishType;
import dietApp.dietapp.repository.DietRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


@Service
@RequiredArgsConstructor
public class DietService {

    private final DietRepository dietRepository;
    private Date date = new Date();


    public Diet addFoodToDiet(String username, DishType dishType,String foodName){

        Diet diet = new Diet();
        diet.setUser(username);
        diet.setDishType(dishType);
        diet.setFood(foodName);
        diet.setDate(date);

        return dietRepository.save(diet);
    }

    public void deleteFood(Long id){
        dietRepository.deleteById(id);
    }

    public List<Diet> getUserDiet(String username){
        return dietRepository.findAllByUser(username);
    }


}
