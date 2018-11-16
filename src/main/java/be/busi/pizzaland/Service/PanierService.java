package be.busi.pizzaland.Service;

import be.busi.pizzaland.model.Panier;
import org.springframework.stereotype.Service;

@Service
public class PanierService {

    public Integer promotionQuantite(Panier panier){
        if(panier.getQuantiteTotal()>30) return 30;
        if(panier.getQuantiteTotal()>20) return 20;
        if(panier.getQuantiteTotal()>10) return 10;
        return 0;
    }
}
