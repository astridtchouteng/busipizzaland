package be.busi.pizzaland.service;

import be.busi.pizzaland.dataAccess.dao.PromotionDAO;
import be.busi.pizzaland.model.Commande;
import be.busi.pizzaland.model.Panier;
import be.busi.pizzaland.model.Promotion;
import org.apache.tomcat.jni.Local;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class PromoService {

    @Autowired
    private PromotionDAO promotionDAO;

    public Double reduction(Double prix){
        Double reduction = 0.0;
        Promotion promotion = promotionDAO.getPromotionActual(LocalDateTime.now());

        if(prix> promotion.getMontantMinimum()){
            reduction =prix*promotion.getPourcentage()/100;
        }

        return reduction;
    }
}
