package dietApp.dietapp.service;

import dietApp.dietapp.food.dto.Food;
import dietApp.dietapp.config.CurrentDateAsString;
import dietApp.dietapp.diet.entity.Diet;
import dietApp.dietapp.diet.entity.DishType;
import dietApp.dietapp.diet.repository.DietRepository;
import dietApp.dietapp.diet.service.impl.DietServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest
class DietServiceImplTest {

    @Autowired
    private DietRepository dietRepository;
    @Autowired
    private DietServiceImpl service;

    private Food chicken;
    private Food egg;
    private String date ;

    @BeforeEach
    void init(){
        chicken = new Food("chicken",100,100,5,5,10,11);
        egg = new Food("egg",100,200,7,5,10,11);
        date = CurrentDateAsString.getTodayDate();
    }

    @Test
    void shouldReturnCorrectSizeOfUserDietBeforeAddFoodToDiet() {
    //given
        service.addFoodToDiet("adas4",DishType.DINNER,chicken);
        service.addFoodToDiet("adas4",DishType.DINNER,chicken);
        int size = 2;
    //when
        List<Diet> found = dietRepository.findAllByUserAndDate("adas4",date);
    //then
        assertThat(found.size()).isEqualTo(size);
    }

    @Test
    void shouldReturnCorrectSizeOfUserDietBeforeDeleteFoodFromDiet(){
        //given
        int size = 1;
        //when
        service.deleteFood(3L);
        List<Diet> found = dietRepository.findAllByUserAndDate("adas4",date);
        //then
        assertThat(found.size()).isEqualTo(size);
    }


}