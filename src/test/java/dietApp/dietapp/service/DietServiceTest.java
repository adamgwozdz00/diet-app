package dietApp.dietapp.service;

import dietApp.dietapp.client.dto.Food;
import dietApp.dietapp.config.CurrentDateAsString;
import dietApp.dietapp.model.Diet;
import dietApp.dietapp.model.DishType;
import dietApp.dietapp.repository.DietRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import java.util.Date;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest
class DietServiceTest {

    @Autowired
    private DietRepository dietRepository;
    @Autowired
    private DietService service;

    private String date ;

    @BeforeEach
    void init(){
        date = CurrentDateAsString.getTodayDate();
    }

    @Test
    void shouldReturnCorrectSizeOfUserDietBeforeAddFoodToDiet() {
    //given
        service.addFoodToDiet("adas4",DishType.DINNER,"egg",100,100,0,5,7,0);
        service.addFoodToDiet("adas4",DishType.DINNER,"chicken",100,200,0,2,3,4);
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