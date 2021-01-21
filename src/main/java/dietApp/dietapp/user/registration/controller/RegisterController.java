package dietApp.dietapp.user.registration.controller;

import dietApp.dietapp.user.entity.User;
import dietApp.dietapp.user.registration.service.UserRegistrationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
@RequiredArgsConstructor
public class RegisterController {

    private final UserRegistrationService registerService;

    @GetMapping("/register")
    public String registration(Model model){
        User user = new User();
        model.addAttribute("user",user);
        return "/register";
    }

    @PostMapping("/register")
    public String createNewUser(@Valid User user, BindingResult bindingResult) throws Exception {
        registerService.registerUser(user);
        return "/login";
    }

}
