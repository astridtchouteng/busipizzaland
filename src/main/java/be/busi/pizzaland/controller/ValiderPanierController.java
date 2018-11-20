package be.busi.pizzaland.controller;


import be.busi.pizzaland.dataAccess.dao.*;
import be.busi.pizzaland.dataAccess.entity.UserEntity;
import be.busi.pizzaland.dataAccess.util.ProviderConverter;
import be.busi.pizzaland.model.*;
import be.busi.pizzaland.service.PanierService;
import be.busi.pizzaland.service.PromoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Controller
@RequestMapping(value = "/validerPanier")
@SessionAttributes({Constants.PANIER})
public class ValiderPanierController {

    @Autowired
    private ProviderConverter providerConverter;

    @Autowired
    private CommandeDAO commandeDAO;

    @Autowired
    private LigneCommandeDAO ligneCommandeDAO;

    @Autowired
    private IngredientDAO ingredientDAO;

    @Autowired
    private PromoService promoService;

    @GetMapping(value = "")
    public String afficher(Model model,
                          @SessionAttribute(value = Constants.PANIER) Panier panier,
                          Authentication authentication) {

        panier.setReduction(promoService.reduction(panier.getPrixTotal()));
        model.addAttribute("prixFinal",panier.getPrixTotal()-panier.getReduction());
        model.addAttribute(Constants.PANIER, panier);
        return "integrated:validate";
    }

    @GetMapping(value = "/process")
    public String viderPanier(Model model,
                              @SessionAttribute(value = Constants.PANIER) Panier panier,
                              Authentication authentication){

        Commande commande = new Commande();

        UserDetails userAuthentication = (UserDetails) authentication.getPrincipal();
        User user = providerConverter.userEntityToUserModel((UserEntity)userAuthentication);
        commande.setUser(user);
        commande.setPrice(panier.getPrixTotal()-panier.getReduction());
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


        Set<LigneCommande> ligneCommandeSaved = new HashSet<>();

        for(LigneCommande ligneCommande : ligneCommandes)
            ligneCommandeSaved.add(ligneCommandeDAO.save(ligneCommande));

        if(ligneCommandes.equals(ligneCommandeSaved))
            panier.vider();
        return "redirect:/home";
    }

}
