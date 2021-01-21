package dietApp.dietapp.diet.controller;

import dietApp.dietapp.CurrentDateAsString;
import dietApp.dietapp.diet.entity.Diet;
import dietApp.dietapp.diet.service.DietService;
import dietApp.dietapp.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class DietController {

    private final DietService dietService;
    private final UserService userService;
    // Date is here because in the future I want to add function that allow to check diet bays before
    private String date = CurrentDateAsString.getTodayDate();

    @GetMapping("/diet")
    public String showUserDiet(Model model){
        List<Diet> userDiet = dietService.getUserDiet(userService.getCurrentUserUsername(),date);
        model.addAttribute("diet",userDiet);
        return "diet";
    }

    @PostMapping("/diet/delete")
    public String deleteUserDiet(@RequestParam(value = "index") Long index){
        dietService.deleteFood(index);
        return "redirect:/diet";
    }





}
