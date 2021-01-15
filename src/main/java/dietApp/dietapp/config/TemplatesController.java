package dietApp.dietapp.config;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class TemplatesController {

    @GetMapping("login")
    public String getLoginView(){
        return "login";
    }

    @GetMapping("success")
    public String getSuccess(){
        return "success";
    }

    @GetMapping("/")
    public String welcome() {
        return "index";
    }
}
