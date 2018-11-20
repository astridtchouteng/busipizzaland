package be.busi.pizzaland.service;

import be.busi.pizzaland.model.Commande;
import be.busi.pizzaland.model.Panier;
import be.busi.pizzaland.model.User;
import org.springframework.stereotype.Service;

@Service
public class PanierService {



    public Integer promotionQuantite(Panier panier){
        if(panier.getQuantiteTotal()>30) return 30;
        if(panier.getQuantiteTotal()>20) return 20;
        if(panier.getQuantiteTotal()>10) return 10;
        return 0;
    }


    public Commande savePanier(Panier panier, User user){
        Commande commande = new Commande();



        return commande;
    }
}
