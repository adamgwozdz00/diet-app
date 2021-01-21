package dietApp.dietapp.controller;

import dietApp.dietapp.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
@RequestMapping("/")
public class TemplatesController {

    @Autowired
    private RegisterService service;



    @GetMapping
    public String welcome() {
        return "index";
    }


}
