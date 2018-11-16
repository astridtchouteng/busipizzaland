package be.busi.pizzaland.controller;


import be.busi.pizzaland.Service.PanierService;
import be.busi.pizzaland.dataAccess.dao.PizzaDAO;
import be.busi.pizzaland.model.Constants;
import be.busi.pizzaland.model.Panier;
import be.busi.pizzaland.model.Pizza;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value = "/traiter")
@SessionAttributes({Constants.PANIER})
public class TraiterPizzas {

    @Autowired
    private PanierService panierService;

    @Autowired
    private PizzaDAO pizzaDAO;

    @ModelAttribute(Constants.PANIER)
    public Panier panier(){
        return new Panier();
    }

    @RequestMapping(method = RequestMethod.GET)
    public String home(@RequestParam(name = "nomPizza", required = false, defaultValue = "world")String nomPizza,
                       Model model,
                       @ModelAttribute(value= Constants.PANIER) Panier panier, BindingResult errors)  {

        Pizza pizza = pizzaDAO.getPizzaByNom(nomPizza);

        if(pizza != null) {
            panier.addPizza(pizza, 1);
        }
        model.addAttribute(Constants.PANIER, panier);

        if(errors.hasErrors()){

            return "redirect:/affciherPizzas";
        }

        return "redirect:/panier";
    }

}
