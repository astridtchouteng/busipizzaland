package be.busi.pizzaland.dataAccess.dao;

import be.busi.pizzaland.dataAccess.entity.LigneCommandeEntity;
import be.busi.pizzaland.model.Commande;
import be.busi.pizzaland.model.LigneCommande;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class LigneCommandeDAO {

    public LigneCommande save(LigneCommandeEntity ligneCommandeEntity){

        return null;
    }
}
