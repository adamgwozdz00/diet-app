package dietApp.dietapp.food.controller;



import com.fasterxml.jackson.core.JsonProcessingException;
import dietApp.dietapp.food.dto.Food;
import dietApp.dietapp.diet.entity.DishType;
import dietApp.dietapp.diet.service.DietService;
import dietApp.dietapp.food.service.FoodService;
import dietApp.dietapp.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;



@Controller
@RequiredArgsConstructor
public class FoodController {

    private final FoodService foodService;
    private final DietService dietService;
    private final UserService userService;
    private Food food = new Food();

    @GetMapping("/foods")
    public String foodSearchForm(Model model){
        model.addAttribute("food", food);
        model.addAttribute("newFood", new Food());
        return "foods";
    }

    @PostMapping("/foods/search")
    public String foodSearchSubmit(@ModelAttribute Food foodName) throws JsonProcessingException {
        food = foodService.searchFood(foodName.getName());
        return "redirect:/foods";
    }

    @GetMapping("/foods/add")
    public String addUserFood(){
        dietService.addFoodToDiet(userService.getCurrentUserUsername(), DishType.OTHER,food);
        return "redirect:/diet";
    }

    @PostMapping("/foods/put")
    public String setNewFoodNutritionValuesByWeight(@ModelAttribute Food newFood){
        food.setNewWeight(newFood.getWeight());
        return "redirect:/foods";
    }



}
