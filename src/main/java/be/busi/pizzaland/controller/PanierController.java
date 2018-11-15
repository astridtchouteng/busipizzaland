package be.busi.pizzaland.controller;

import be.busi.pizzaland.dataAccess.dao.CommandeDAO;
import be.busi.pizzaland.dataAccess.dao.PizzaDAO;
import be.busi.pizzaland.dataAccess.dao.UserDAO;
import be.busi.pizzaland.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Controller
@RequestMapping(value = "/panier")
@SessionAttributes({Constants.PANIER})
public class PanierController {


    @Autowired
    private PizzaDAO pizzaDAO;

    @Autowired
    private UserDAO userDAO;

    @Autowired
    private CommandeDAO commandeDAO;

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

// unit test
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

    @RequestMapping(value = "/supprimer", method = RequestMethod.GET)
    public String supprimerParPizza(@RequestParam(name = "nomPizza", required = false, defaultValue = "world")String nomPizza,
                                    Model model, @ModelAttribute(Constants.PANIER) Panier panier, BindingResult errors){

        if(errors.hasErrors()){
            return "integrated:afficherPizzas";
        }
//unit test
        Pizza pizza = pizzaDAO.getPizzaByNom(nomPizza);

        if(pizza != null)
            panier.supprimerParPizza(pizza);

        return "redirect:/panier";
    }

    @RequestMapping(value = "/vider", method = RequestMethod.GET)
    public String vider(Model model, @ModelAttribute(Constants.PANIER) Panier panier, BindingResult errors) {

        if(errors.hasErrors()){
            return "integrated:afficherPizzas";
        }

        panier.vider();
        return "redirect:/panier";
    }

    @RequestMapping(value = "/valider", method = RequestMethod.GET)
    public String valider(Model model, @ModelAttribute(Constants.PANIER) Panier panier, BindingResult errors,
                          Authentication authentication,
                          @ModelAttribute(Constants.CURRENT_USER) User user) {

        UserDetails u = (UserDetails) authentication.getPrincipal();

        user = userDAO.getCurrentUser(u.getUsername());

        Commande commande = new Commande();
        commande.setUser(user);

        EtatCommande etatCommande = new EtatCommande();
        etatCommande.setEtatCommandeEnum(EtatCommandeEnum.NON_PAYE);

        commande.setEtatCommande(etatCommande);
        Commande commandeSaved = commandeDAO.save(commande);

        LigneCommande ligneCommande = new LigneCommande();




        if(user == null){

            if(authentication != null){


            }
        }

        if(errors.hasErrors()){
            return "integrated:afficherPizzas";
        }


        return "redirect:/panier";
    }


}
