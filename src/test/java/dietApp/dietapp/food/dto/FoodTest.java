package dietApp.dietapp.food.dto;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FoodTest {

    @Test
    void shouldSetNewWeight() {
        //given
        Food testCase = new Food("food",255,247,15,19,10,5);
        //when
        testCase.setNewWeight(100);
        //then
        assertEquals(((float)247/255)*100,testCase.getCalories());
    }

}