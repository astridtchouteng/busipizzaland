package be.busi.pizzaland.controller;


import be.busi.pizzaland.dataAccess.dao.CategorieDAO;
import be.busi.pizzaland.dataAccess.dao.IngredientDAO;
import be.busi.pizzaland.dataAccess.dao.PizzaDAO;
import be.busi.pizzaland.model.Constants;
import be.busi.pizzaland.model.Ingredient;
import be.busi.pizzaland.model.LigneCommande;
import be.busi.pizzaland.model.Pizza;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;


import java.util.*;

import static be.busi.pizzaland.model.Constants.PANIER;
import static be.busi.pizzaland.model.Constants.PIZZAS;

@Controller
@RequestMapping(value = "/home")
@SessionAttributes({PIZZAS, PANIER,Constants.CURRENT_USER})
public class HomeController {

    @Autowired
    private PizzaDAO pizzaDAO;

    @Autowired
    private CategorieDAO categorieDAO;

    @Autowired
    private IngredientDAO ingredientDAO;


    @RequestMapping(method = RequestMethod.GET)
    public String home(Model model) {
        model.addAttribute(Constants.PIZZAS, pizzaDAO.getAll());
        model.addAttribute("categories", categorieDAO.getAll());
        return "integrated:welcome";
    }

    @RequestMapping(value = "/panier", method = RequestMethod.POST)
    public String ajouterAuPanier(@RequestParam(name = "nomPizza", required = false,
                                                               defaultValue = "world")String nomPizza,
                                  Model model,
                                  @ModelAttribute(value=Constants.PANIER) Map<Pizza, Integer> panier,
                                  BindingResult errors,
                                  @ModelAttribute("commande") LigneCommande ligneCommande)  {
        if(errors.hasErrors()){
            return "redirect:/afficherPizzas";
        }

        return "redirect:/welcome";
    }
}
