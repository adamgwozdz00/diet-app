package dietApp.dietapp.controller;

import dietApp.dietapp.model.User;
import dietApp.dietapp.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
@RequestMapping("/")
public class TemplatesController {

    @Autowired
    private RegisterService service;

    @GetMapping("success")
    public String getSuccess(){
        return "success";
    }

    @GetMapping
    public String welcome() {
        return "index";
    }


}
