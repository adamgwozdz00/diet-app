package dietApp.dietapp.user.controller;

import dietApp.dietapp.user.entity.User;
import dietApp.dietapp.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/register")
    public String registration(Model model){
        User user = new User();
        model.addAttribute("user",user);
        return "/register";
    }

    @GetMapping("login")
    public String getLoginView(){
        return "login";
    }


    @PostMapping("/register")
    public String createNewUser(User user) throws Exception {
        if(userService.registerUser(user) != null)
            return "/login";
        else return "/register";
    }

    @GetMapping("/register/confirm")
    public String confirmUser(@RequestParam(value = "token") String token){
        userService.confirmUser(token);
        return "/login";
    }

}
