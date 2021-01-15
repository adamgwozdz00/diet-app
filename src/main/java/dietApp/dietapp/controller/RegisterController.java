package dietApp.dietapp.controller;

import dietApp.dietapp.model.User;
import dietApp.dietapp.service.RegisterService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class RegisterController {

    private final RegisterService service;

    @PostMapping("register")
    public User registration(@RequestBody User user) throws Exception {
        return service.registerUser(user);
    }
}
