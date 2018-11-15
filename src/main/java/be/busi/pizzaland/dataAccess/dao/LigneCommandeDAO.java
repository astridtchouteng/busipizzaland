package be.busi.pizzaland.dataAccess.dao;

import be.busi.pizzaland.dataAccess.entity.LigneCommandeEntity;
import be.busi.pizzaland.dataAccess.repository.LigneCommandeRepository;
import be.busi.pizzaland.dataAccess.util.ProviderConverter;
import be.busi.pizzaland.model.Commande;
import be.busi.pizzaland.model.LigneCommande;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class LigneCommandeDAO {

    @Autowired
    private ProviderConverter providerConverter;

    @Autowired
    private LigneCommandeRepository ligneCommandeRepository;

    public LigneCommande save(LigneCommande ligneCommande){

        LigneCommandeEntity ldcEntity = providerConverter.ligneCommandeToLigneCommandeEntity(ligneCommande);

        LigneCommandeEntity ldcEntitySaved = ligneCommandeRepository.save(ldcEntity);

        return providerConverter.ligneCommandeEntityToLigneCommande(ldcEntitySaved);
    }
}
