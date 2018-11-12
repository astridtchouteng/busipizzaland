package be.busi.pizzaland.controller;


import be.busi.pizzaland.Service.CategorieService;
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
    private CategorieService categorieService;

    @ModelAttribute(Constants.PIZZAS)
    public Set<Pizza> pizzas(){
        return new HashSet<>();
    }

    @RequestMapping(method = RequestMethod.GET)
    public String home(Model model, @ModelAttribute(Constants.PIZZAS) Set<Pizza> pizzas) {

        if(pizzas == null || pizzas.isEmpty()){
            pizzas = pizzaDAO.getAll();
            model.addAttribute(Constants.PIZZAS, pizzas);
        }

        System.out.println(pizzas);

        Set<CategorieEnum> categorieEnums = categorieService.getCategories();
        List<String> catStrings = categorieEnums.stream().map(categorieEnum -> categorieEnum.getName()).collect(Collectors.toList());
        model.addAttribute("cats", catStrings);
        return "integrated:afficherPanier";
    }

    @RequestMapping(value = "/categorie", method = RequestMethod.GET)
    public String pizzaParCategorie(@RequestParam(name = "categorie", required = false, defaultValue = "world") String categorie,
                                    Model model) {

        Set<Pizza> pizzaTries = pizzaDAO.pizzaByCategorie(categorie);
       model.addAttribute(Constants.PIZZAS, pizzaTries);

        return "redirect:/home";
    }


}
