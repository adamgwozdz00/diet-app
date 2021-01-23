package dietApp.dietapp.diet.repository;

import dietApp.dietapp.CurrentDateAsString;
import dietApp.dietapp.diet.dto.NutritionValuesDto;
import dietApp.dietapp.diet.entity.Diet;
import dietApp.dietapp.diet.entity.DishType;

import org.junit.jupiter.api.BeforeAll;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class DietRepositoryTest {

    @Autowired
    DietRepository dietRepository;

    private String today;
    private List<Diet> dietList;
    private Diet dietOne;
    private Diet dietTwo;
    private Diet dietThree;
    @BeforeAll
    void init(){
        dietList = new ArrayList<>();
        today = CurrentDateAsString.getTodayDate();
        dietOne = new Diet("user1", DishType.OTHER,"chicken",100,100,21,1,0,0, today);
        dietTwo = new Diet("user2", DishType.DINNER,"beef",100,200,25,10,0,0, today);
        dietThree = new Diet("user1", DishType.OTHER,"chicken",100,100,21,1,0,0,"2020-12-10");
        dietList.add(dietOne);
        dietList.add(dietTwo);
        dietList.add(dietThree);
        dietRepository.saveAll(dietList);
    }
    @Test
    void shouldReturnCorrectSizeOfDietByUsingFindAllByUserAndDate() {
        //given
        int size = 1;
        //when
        List<Diet> result = dietRepository.findAllByUserAndDate("user1", today);
        //then
        assertThat(result.size()).isEqualTo(size);
    }

    @Test
    void  shouldReturnCorrectlyDiet(){
        //given
        Diet diet = new Diet("user1", DishType.OTHER,"chicken",100,100,21,1,0,0, today);
        //when
        Diet result = dietRepository.findAllByUserAndDate("user1", today).get(0);
        //then
        assertThat(result.getFood()).isEqualTo(diet.getFood());
        assertThat(result.getDate()).isEqualTo(diet.getDate());
    }

    @Test
    void shouldGetCorrectTotalNutritionValues(){
        //given
        String user = dietOne.getUser();
        //when
        NutritionValuesDto nutritionValuesDto = dietRepository.getTotalNutritionValues(user, today).orElseThrow();
        //then
        assertThat(nutritionValuesDto.getCalories()).isEqualTo(dietOne.getCalories());
        assertThat(nutritionValuesDto.getProtein()).isEqualTo(dietOne.getProtein());
        assertThat(nutritionValuesDto.getFat()).isEqualTo(dietOne.getFat());
        assertThat(nutritionValuesDto.getCarbs()).isEqualTo(dietOne.getCarbohydrates());
        assertThat(nutritionValuesDto.getSugar()).isEqualTo(dietOne.getSugar());
    }


}