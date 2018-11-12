package be.busi.pizzaland.controller;


import be.busi.pizzaland.dataAccess.entity.RoleEntity;
import be.busi.pizzaland.dataAccess.repository.RoleRepository;
import be.busi.pizzaland.model.Constants;
import be.busi.pizzaland.model.RoleEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@RequestMapping(value = "/home")
@SessionAttributes({Constants.CURRENT_USER})
public class HomeController {

    @GetMapping
    public String home(Model model) {
        model.addAttribute("titre","Pizza BIO");
        return "integrated:welcome";
    }
}
