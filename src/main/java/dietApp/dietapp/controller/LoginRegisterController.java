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
public class LoginRegisterController {

    @Autowired
    private RegisterService service;

    @GetMapping("login")
    public String getLoginView(){
        return "login";
    }

    @RequestMapping(value="/register", method = RequestMethod.GET)
    public ModelAndView registration(){
        ModelAndView modelAndView = new ModelAndView();
        User user = new User();
        modelAndView.addObject("user", user);
        modelAndView.setViewName("register");
        return modelAndView;
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ModelAndView createNewUser(@Valid User user, BindingResult bindingResult) throws Exception {
        ModelAndView modelAndView = new ModelAndView();
        service.registerUser(user);
        modelAndView.setViewName("register");
        return modelAndView;
    }
}
