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
        dietOne =  Diet.builder()
                .user("user1")
                .date(today)
                .dishType(DishType.OTHER)
                .food("chicken")
                .weight(100)
                .calories(100)
                .protein(21)
                .fat(1)
                .carbohydrates(0)
                .sugar(0)
                .build();
        dietTwo = Diet.builder()
                .user("user2")
                .date(today)
                .dishType(DishType.OTHER)
                .food("beef")
                .weight(100)
                .calories(200)
                .protein(24)
                .fat(10)
                .carbohydrates(0)
                .sugar(0)
                .build();
        dietThree = Diet.builder()
                .user("user1")
                .date("21-01-2021")
                .dishType(DishType.OTHER)
                .food("chicken")
                .weight(100)
                .calories(100)
                .protein(21)
                .fat(1)
                .carbohydrates(0)
                .sugar(0)
                .build();
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
        //when
        Diet result = dietRepository.findAllByUserAndDate("user1", today).get(0);
        //then
        assertThat(result.getFood()).isEqualTo(dietOne.getFood());
        assertThat(result.getDate()).isEqualTo(dietOne.getDate());
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