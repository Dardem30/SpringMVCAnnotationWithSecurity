package by.controller;

import by.model.UserEntity;
import by.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by УВД on 11.08.2017.
 */
@Controller
public class MainController {
    @Autowired
    private UserService userService;
    @RequestMapping(value = "/",method = RequestMethod.GET)
    public String main(){
        return "index";
    }
    @RequestMapping(value = "/login")
    public String login(){
        return "login";
    }
    @RequestMapping(value = "/registration",method = RequestMethod.GET)
    public String registration(Model model){
        model.addAttribute("userForm",new UserEntity());
        return "registration";
    }
    @RequestMapping(value = "/registration",method = RequestMethod.POST)
    public String registration(@ModelAttribute("userForm")UserEntity user){
        userService.saveUser(user);
        return "redirect:/login";
    }
}
