package dietApp.dietapp.controller;

import dietApp.dietapp.config.CurrentDateAsString;
import dietApp.dietapp.model.Diet;
import dietApp.dietapp.service.DietService;
import dietApp.dietapp.service.UserService;
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
