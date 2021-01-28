package dietApp.dietapp.food.validate;

import dietApp.dietapp.food.dto.Food;

public class FoodValidation {

    public static boolean isFoodExist(Food food){
        if (food.getWeight() <= 0)
            return false;
        return true;
    }
}
