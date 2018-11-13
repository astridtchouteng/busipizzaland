package be.busi.pizzaland.controller;

import be.busi.pizzaland.dataAccess.dao.PizzaDAO;
import be.busi.pizzaland.model.Constants;
import be.busi.pizzaland.model.LigneCommande;
import be.busi.pizzaland.model.Panier;
import be.busi.pizzaland.model.Pizza;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping(value = "/panier")
@SessionAttributes({Constants.PANIER})
public class PanierController {


    @Autowired
    private PizzaDAO pizzaDAO;

    @ModelAttribute(Constants.PANIER)
    public Panier panier(){
        return new Panier();
    }

    @RequestMapping(method = RequestMethod.GET)
    public String home(Model model)  {

        return "integrated:afficherPanier";
    }

    @RequestMapping(value = "/modifier", method = RequestMethod.GET)
    public String modifier(@RequestParam(name = "nomPizza", required = false, defaultValue = "world")String nomPizza,
            @RequestParam(name = "operation", required = false, defaultValue = "world")String operation,
                                  Model model,
                                  @ModelAttribute(value= Constants.PANIER) Panier panier, BindingResult errors)  {


        Pizza pizza = pizzaDAO.getPizzaByNom(nomPizza);

        if(pizza != null){

            if(operation.equals("plus"))
                panier.addPizza(pizza, 1);
            else if(operation.equals("moins"))
                panier.removePizza(pizza, 1);
        }


        if(errors.hasErrors()){

            return "redirect:/affciherPizzas";
        }

        return "redirect:/panier";
    }


}