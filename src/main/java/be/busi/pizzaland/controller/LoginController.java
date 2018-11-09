package be.busi.pizzaland.controller;


import be.busi.pizzaland.dataAccess.entity.UserEntity;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/login")
public class LoginController {

    // je dois utiliser User et pas UserEntity
    @ModelAttribute("user")
    public UserEntity userEntity(){
        return new UserEntity();
    }

    @RequestMapping(method = RequestMethod.GET)
    public String login() {

        return "integrated:loginUser";
    }
}
