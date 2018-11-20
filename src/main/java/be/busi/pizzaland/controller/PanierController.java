package be.busi.pizzaland.controller;

import be.busi.pizzaland.service.PanierService;
import be.busi.pizzaland.dataAccess.dao.*;
import be.busi.pizzaland.dataAccess.entity.UserEntity;
import be.busi.pizzaland.dataAccess.util.ProviderConverter;
import be.busi.pizzaland.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.*;


@Controller
@RequestMapping(value = "/panier")
@SessionAttributes({Constants.PANIER,"monStock"})
public class PanierController {

    @Autowired
    private PanierService panierService;
    @Autowired
    private ProviderConverter providerConverter;

    @Autowired
    private PizzaDAO pizzaDAO;

    @Autowired
    private UserDAO userDAO;

    @Autowired
    private CommandeDAO commandeDAO;

    @Autowired
    private LigneCommandeDAO ligneCommandeDAO;

    @Autowired
    private IngredientDAO ingredientDAO;

    @Autowired
    private PortionDAO portionDAO;

    @ModelAttribute(Constants.PANIER)
    public Panier panier(){
        return new Panier();
    }

    @RequestMapping(method = RequestMethod.GET)
    public String home(Model model, @ModelAttribute(Constants.PANIER) Panier panier)  {
        if(panier.getMonStock() == null)
            panier.setMonStock("");
        return "integrated:afficherPanier";
    }

    @RequestMapping(value = "/modifier", method = RequestMethod.GET)
    public String modifier(@RequestParam(name = "nomPizza",required = false,
                                                            defaultValue = "world")String nomPizza,
                           @RequestParam(name = "operation", required = false,
                                                  defaultValue = "world")String operation,
                           Model model,
                           @ModelAttribute(value= Constants.PANIER) Panier panier,
                           BindingResult errors)  {

        Pizza pizza = pizzaDAO.getPizzaByNom(nomPizza);
        if(pizza != null){

            if(operation.equals("plus")) {
                //si ingredient suffisant
                List<Portion> portions = portionDAO.findPortionbyPizzaId(pizza.getId());
                List<Ingredient> ingredients = ingredientDAO.getAllIngredients();
                Map<Long,Integer> idIngredientStock = new HashMap<>();

                Boolean ok = true;
                int i=0, j=0;
                for(i=0; i<portions.size() && ok ; i++){
                    for(j=0; j<ingredients.size() && ok; j++){
                        if(portions.get(i).getIdIngredient().equals(ingredients.get(j).getId()) &&
                            portions.get(i).getPortion() > ingredients.get(j).getStock()){
                            ok=false;
                        }
                    }
                    if(!ok){
                        panier.setMonStock("Pas de Stock");
                        return "redirect:/panier";
                    }
                    idIngredientStock.put(portions.get(i).getIdIngredient(), portions.get(i).getPortion());
                }
                //les portions sont bonnes et je dois diminuer les stocks

                for (Map.Entry<Long, Integer> key : idIngredientStock.entrySet()) {
                    Ingredient ingredient = ingredientDAO.getIngredientById(key.getKey());
                    ingredient.setStock(ingredient.getStock()-key.getValue());
                    ingredientDAO.updateStock(ingredient);
                }
                panier.addPizza(pizza, 1);
            }else if(operation.equals("moins"))
                panier.removePizza(pizza, 1);
        }


        if(errors.hasErrors()){

            return "redirect:/affciherPizzas";
        }

        return "redirect:/panier";
    }

    @RequestMapping(value = "/supprimer", method = RequestMethod.GET)
    public String supprimerParPizza(@RequestParam(name = "nomPizza",
                                                      required = false, defaultValue = "world")String nomPizza,
                                    Model model,
                                    @ModelAttribute(Constants.PANIER) Panier panier,
                                    BindingResult errors){

        if(errors.hasErrors()){
            return "integrated:afficherPizzas";
        }
        Pizza pizza = pizzaDAO.getPizzaByNom(nomPizza);

        if(pizza != null)
            panier.supprimerParPizza(pizza);

        return "redirect:/panier";
    }

    @RequestMapping(value = "/vider", method = RequestMethod.GET)
    public String vider(Model model,
                        @ModelAttribute(Constants.PANIER) Panier panier, BindingResult errors) {

        if(errors.hasErrors()){
            return "integrated:afficherPizzas";
        }

        panier.vider();
        return "redirect:/panier";
    }

    @RequestMapping(value = "/valider", method = RequestMethod.GET)
    public String valider(Model model, @ModelAttribute(Constants.PANIER) Panier panier,
                          BindingResult errors,
                          Authentication authentication) {
        if(errors.hasErrors()){
            return "integrated:afficherPizzas";
        }
        Commande commande = new Commande();

        UserDetails userAuthentication = (UserDetails) authentication.getPrincipal();
        User user = providerConverter.userEntityToUserModel((UserEntity)userAuthentication);
        commande.setUser(user);
        commande = commandeDAO.save(commande);

        List<Ingredient> allIngredients = ingredientDAO.getAllIngredients();


        Set<LigneCommande> ligneCommandes = new HashSet<>();

        for(Pizza pizza : panier.getContenu().keySet()) {

            LigneCommande ligneCommande = new LigneCommande();
            ligneCommande.setQuantite(panier.get(pizza));
            ligneCommande.setIdCommande(commande.getId());
            ligneCommande.setIdPizza(pizza.getId());
            ligneCommandes.add(ligneCommande);
        }

        int pourcentagePromotion = panierService.promotionQuantite(panier);
        panier.setPrixTotal(panier.getPrixTotal()*pourcentagePromotion);

        Set<LigneCommande> ligneCommandeSaved = new HashSet<>();

        for(LigneCommande ligneCommande : ligneCommandes)
            ligneCommandeSaved.add(ligneCommandeDAO.save(ligneCommande));

        if(ligneCommandes.equals(ligneCommandeSaved))
            panier.vider();

        return "redirect:/home";
    }


}
