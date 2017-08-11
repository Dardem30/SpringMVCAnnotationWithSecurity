package by.controller;

import by.model.UserEntity;
import by.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by УВД on 11.08.2017.
 */
@Controller
@RequestMapping(value = "/controller")
public class RESTController {
    @Autowired
    private UserService userService;
    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    @ResponseBody
    public String getUser(Model model, @PathVariable int id){
       UserEntity userEntity=userService.getUserEntityById(id);
        return userEntity.getUsername();
    }
}
