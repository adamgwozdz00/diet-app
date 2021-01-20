package dietApp.dietapp.service;

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

    private Date date;

    @BeforeEach
    void init(){
        date = new Date();
    }

    @Test
    void shouldReturnCorrectSizeOfUserDietBeforeAddFoodToDiet() {
    //given
        service.addFoodToDiet("adas4",DishType.DINNER,"egg");
        service.addFoodToDiet("adas4",DishType.DINNER,"chicken");
        int size = 2;
    //when
        List<Diet> found = dietRepository.findAllByUser("adas4");
    //then
        assertThat(found.size()).isEqualTo(size);
    }

    @Test
    void shouldReturnCorrectSizeOfUserDietBeforeDeleteFoodFromDiet(){
        //given
        int size = 1;
        //when
        service.deleteFood(3L);
        List<Diet> found = dietRepository.findAllByUser("adas4");
        //then
        assertThat(found.size()).isEqualTo(size);
    }


}