package be.busi.pizzaland.controller;


import be.busi.pizzaland.dataAccess.dao.CategorieDAO;
import be.busi.pizzaland.dataAccess.dao.PizzaDAO;
import be.busi.pizzaland.model.Constants;
import be.busi.pizzaland.model.Pizza;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Set;

@Controller
@RequestMapping(value = "/categorie")
public class CategorieController {

    @Autowired
    private PizzaDAO pizzaDAO;

    @Autowired
    private CategorieDAO categorieDAO;

    @RequestMapping( method = RequestMethod.GET)
    public String pizzaParCategorie(@RequestParam(name = "categorie",
                                                         defaultValue = "VEGETARIENNE") String categorie,
                                    Model model) {

        Set<Pizza> pizzaTries = pizzaDAO.pizzaByCategorie(categorie);
        model.addAttribute("categorie", categorie);
        model.addAttribute(Constants.PIZZAS, pizzaTries);
        model.addAttribute("categories", categorieDAO.getAll());

        return "integrated:categorie";
    }
}
