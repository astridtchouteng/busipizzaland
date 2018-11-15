package be.busi.pizzaland.dataAccess.dao;

import be.busi.pizzaland.dataAccess.entity.LigneCommandeEntity;
import be.busi.pizzaland.dataAccess.entity.PortionEntity;
import be.busi.pizzaland.dataAccess.entity.PortionId;
import be.busi.pizzaland.dataAccess.repository.LigneCommandeRepository;
import be.busi.pizzaland.dataAccess.repository.PizzaRepository;
import be.busi.pizzaland.dataAccess.repository.PortionRepository;
import be.busi.pizzaland.dataAccess.util.ProviderConverter;
import be.busi.pizzaland.model.Commande;
import be.busi.pizzaland.model.Ingredient;
import be.busi.pizzaland.model.LigneCommande;
import be.busi.pizzaland.model.Pizza;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

@Service
@Transactional
public class LigneCommandeDAO {

    @Autowired
    private ProviderConverter providerConverter;

    @Autowired
    private PizzaRepository pizzaRepository;

    @Autowired
    private PortionRepository portionRepository;

    @Autowired
    private LigneCommandeRepository ligneCommandeRepository;

    public LigneCommande save(LigneCommande ligneCommande){

        LigneCommandeEntity ldcEntity = providerConverter.ligneCommandeToLigneCommandeEntity(ligneCommande);

        LigneCommandeEntity ldcEntitySaved = ligneCommandeRepository.save(ldcEntity);

        Pizza pizza = providerConverter.pizzaEntityToPizzaModel(pizzaRepository.findOne(ligneCommande.getIdPizza()));

        return providerConverter.ligneCommandeEntityToLigneCommande(ldcEntitySaved);
    }
}
