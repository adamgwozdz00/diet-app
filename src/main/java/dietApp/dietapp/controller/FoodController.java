package dietApp.dietapp.controller;



import com.fasterxml.jackson.core.JsonProcessingException;
import dietApp.dietapp.client.dto.Food;
import dietApp.dietapp.service.FoodService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequiredArgsConstructor
public class FoodController {

    private final FoodService service;
    private Food food = new Food();

    @GetMapping("/foods")
    public String foodSearchForm(Model model){
        model.addAttribute("food", food);
        model.addAttribute("foodName", new Food());
        return "foods";
    }

    @PostMapping("/foods")
    public String foodSearchSubmit(@ModelAttribute Food foodName) throws JsonProcessingException {
        food = service.searchFood(foodName.getName());
        return "redirect:/foods";
    }

}
