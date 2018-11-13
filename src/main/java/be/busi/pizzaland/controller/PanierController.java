package be.busi.pizzaland.controller;

import be.busi.pizzaland.dataAccess.dao.PizzaDAO;
import be.busi.pizzaland.model.Constants;
import be.busi.pizzaland.model.LigneCommande;
import be.busi.pizzaland.model.Pizza;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping(value = "/panier")
@SessionAttributes({Constants.PANIER})
public class PanierController {


    @Autowired
    private PizzaDAO pizzaDAO;

    @ModelAttribute(Constants.PANIER)
    public Map<Pizza, Integer> panier(){
        return new HashMap<>();
    }

    @RequestMapping(method = RequestMethod.GET)
    public String ajouterAuPanier(@RequestParam(name = "nomPizza", required = false, defaultValue = "world")String nomPizza,
                                  Model model,
                                  @ModelAttribute(value= Constants.PANIER) Map<Pizza, Integer> panier, BindingResult errors)  {




        Pizza pizza = pizzaDAO.getPizzaByNom(nomPizza);

        if(pizza != null) {
            if(!panier.containsKey(pizza))
                panier.put(pizza, 1);
            else panier.put(pizza, panier.get(pizza) + 1);
        }
        model.addAttribute(Constants.PANIER, panier);

        System.out.println(pizza);
        System.out.println(panier);

        if(errors.hasErrors()){

            return "redirect:/affciherPizzas";
        }


        return "integrated:/afficherPanier";
    }
}
