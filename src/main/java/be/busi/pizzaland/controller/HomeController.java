package be.busi.pizzaland.controller;


import be.busi.pizzaland.Service.CategorieService;
import be.busi.pizzaland.dataAccess.dao.PizzaDAO;
import be.busi.pizzaland.model.CategorieEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Controller
@RequestMapping(value = "/home")
public class HomeController {

    @Autowired
    private PizzaDAO pizzaDAO;
    @Autowired
    private CategorieService categorieService;

    @GetMapping
    public String home(Model model) {
        model.addAttribute("titre","Pizza BIO");
        Set<CategorieEnum> categorieEnums = categorieService.getCategories();
        List<String> catStrings = categorieEnums.stream().map(categorieEnum -> categorieEnum.getName()).collect(Collectors.toList());
        model.addAttribute("cats", catStrings);
        model.addAttribute("t", catStrings.get(0));
        model.addAttribute("pizzas", pizzaDAO.getAll());
        return "integrated:welcome";
    }

}
