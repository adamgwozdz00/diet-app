package dietApp.dietapp.controller;

import dietApp.dietapp.client.dto.Food;
import dietApp.dietapp.config.CurrentDateAsString;
import dietApp.dietapp.model.Diet;
import dietApp.dietapp.service.DietService;
import dietApp.dietapp.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class DietController {

    private final DietService dietService;
    private final UserService userService;
    private String date = CurrentDateAsString.getTodayDate();

    @GetMapping("/diet")
    public String showUserDiet(Model model){
        List<Diet> userDiet = dietService.getUserDiet(userService.getCurrentUserUsername(),date);
        model.addAttribute("diet",userDiet);
        return "diet";
    }

    @DeleteMapping("/diet/delete")
    public String deleteUserDiet(@ModelAttribute Long id){
        dietService.deleteFood(id);
        return "redirect:/diet";
    }





}
