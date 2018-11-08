package be.busi.pizzaland.controller;


import be.busi.pizzaland.dataAccess.entity.RoleEntity;
import be.busi.pizzaland.dataAccess.repository.RoleRepository;
import be.busi.pizzaland.model.RoleEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/home")
public class HomeController {

    @Autowired
    private RoleRepository roleRepository;

    @GetMapping
    public String home(Model model) {


        model.addAttribute("titre","Pizza BIO");
        return "integrated:welcome";
    }
}
