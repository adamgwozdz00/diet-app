package dietApp.dietapp.controller;



import com.fasterxml.jackson.core.JsonProcessingException;
import dietApp.dietapp.client.dto.Food;
import dietApp.dietapp.model.Diet;
import dietApp.dietapp.service.DietService;
import dietApp.dietapp.service.FoodService;
import dietApp.dietapp.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@Controller
@RequiredArgsConstructor
public class FoodController {

    private final FoodService foodService;
    private final DietService dietService;
    private final UserService userService;
    private Food food = new Food();
    private List<Diet> userDiet = new ArrayList<>();

    @GetMapping("/foods")
    public String foodSearchForm(Model model){
        model.addAttribute("userDiet",userDiet);
        model.addAttribute("food", food);
        model.addAttribute("foodName", new Food());
        return "foods";
    }

    @PostMapping("/foods")
    public String foodSearchSubmit(@ModelAttribute Food foodName) throws JsonProcessingException {
        food = foodService.searchFood(foodName.getName());
        userDiet = dietService.getUserDiet(userService.getCurrentUserUsername());
        return "redirect:/foods";
    }

}
