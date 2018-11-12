package be.busi.pizzaland.controller;


import be.busi.pizzaland.Service.CategorieService;
import be.busi.pizzaland.dataAccess.dao.CategorieDAO;
import be.busi.pizzaland.dataAccess.dao.PizzaDAO;
import be.busi.pizzaland.model.CategorieEnum;
import be.busi.pizzaland.model.Constants;
import be.busi.pizzaland.model.Pizza;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Controller
@RequestMapping(value = "/home")
@SessionAttributes({Constants.CURRENT_USER})
public class HomeController {

    @Autowired
    private PizzaDAO pizzaDAO;



    @Autowired
    private CategorieDAO categorieDAO;

    @RequestMapping(method = RequestMethod.GET)
    public String home(Model model) {

         model.addAttribute(Constants.PIZZAS, pizzaDAO.getAll());
        model.addAttribute("categories", categorieDAO.getAll());
        return "integrated:welcome";
    }


}
