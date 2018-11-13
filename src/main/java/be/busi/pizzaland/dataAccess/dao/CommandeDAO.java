package be.busi.pizzaland.dataAccess.dao;

import be.busi.pizzaland.dataAccess.entity.CategorieEntity;
import be.busi.pizzaland.dataAccess.entity.CommandeEntity;
import be.busi.pizzaland.dataAccess.util.ProviderConverter;
import be.busi.pizzaland.model.Commande;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CommandeDAO {

    @Autowired
    private ProviderConverter providerConverter;

    @Autowired
    private CommandeRepository commandeRepository;

    public Commande save(Commande commande) {

        CommandeEntity commandeEntity  = providerConverter.CommandeToComandeEntity(commande);
        CommandeEntity commandeEntitySaved = commandeRepository.save(commandeEntity);
        return providerConverter.commandeEntityToCommande(commandeEntitySaved);

    }
}