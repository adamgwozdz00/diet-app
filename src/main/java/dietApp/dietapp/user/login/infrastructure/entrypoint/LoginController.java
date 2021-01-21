package dietApp.dietapp.user.login.infrastructure.entrypoint;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping("login")
    public String getLoginView(){
        return "login";
    }

}
