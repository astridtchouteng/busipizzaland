package be.busi.pizzaland.controller;


import be.busi.pizzaland.Service.CategorieService;
import be.busi.pizzaland.dataAccess.dao.PizzaDAO;
import be.busi.pizzaland.model.CategorieEnum;
import be.busi.pizzaland.model.Constants;
import be.busi.pizzaland.model.LigneCommande;
import be.busi.pizzaland.model.Pizza;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;


import java.util.*;
import java.util.stream.Collectors;

import static be.busi.pizzaland.model.Constants.PANIER;
import static be.busi.pizzaland.model.Constants.PIZZAS;

@Controller
@RequestMapping(value = "/home")
@SessionAttributes({PIZZAS, PANIER})
public class HomeController {

    @Autowired
    private PizzaDAO pizzaDAO;
    @Autowired
    private CategorieService categorieService;

    @ModelAttribute(PIZZAS)
    public Set<Pizza> pizzas(){
        return new HashSet<>();
    }


    @ModelAttribute(PANIER)
    public Map<Pizza, Integer> panier(){
        return new HashMap<>();
    }

    @ModelAttribute("commande")
    public LigneCommande ligneCommande(){
        return new LigneCommande();
    }

    @RequestMapping(method = RequestMethod.GET)
    public String home(Model model, @ModelAttribute(PIZZAS) Set<Pizza> pizzas) {

        if(pizzas == null || pizzas.isEmpty()){
            pizzas = pizzaDAO.getAll();
            model.addAttribute(PIZZAS, pizzas);
        }

        //System.out.println(pizzas);

        Set<CategorieEnum> categorieEnums = categorieService.getCategories();
        List<String> catStrings = categorieEnums.stream().map(categorieEnum -> categorieEnum.getName()).collect(Collectors.toList());
        model.addAttribute("cats", catStrings);
        return "integrated:welcome";
    }

    @RequestMapping(value = "/categorie", method = RequestMethod.GET)
    public String pizzaParCategorie(@RequestParam(name = "categorie", required = false, defaultValue = "world") String categorie,
                                    Model model) {

        Set<Pizza> pizzaTries = pizzaDAO.pizzaByCategorie(categorie);

        System.out.println(pizzaTries);

        model.addAttribute(PIZZAS, pizzaTries);

        return "redirect:/home";
    }

    @RequestMapping(value = "/panier", method = RequestMethod.POST)
    public String ajouterAuPanier(@RequestParam(name = "nomPizza", required = false, defaultValue = "world")String nomPizza,
                                  Model model, @ModelAttribute(value=Constants.PANIER) Map<Pizza, Integer> panier,  BindingResult errors,
                                  @ModelAttribute("commande") LigneCommande ligneCommande)  {


        System.out.println(ligneCommande);

        if(errors.hasErrors()){

            return "redirect:/affciherPizzas";
        }


        return "redirect:/welcome";
    }




}
