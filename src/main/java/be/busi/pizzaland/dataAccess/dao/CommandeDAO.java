package be.busi.pizzaland.dataAccess.dao;

import be.busi.pizzaland.dataAccess.entity.CommandeEntity;
import be.busi.pizzaland.dataAccess.repository.CommandeRepository;
import be.busi.pizzaland.dataAccess.repository.CommandeRepository;
import be.busi.pizzaland.dataAccess.repository.EtatCommandeRepository;
import be.busi.pizzaland.dataAccess.repository.PizzaRepository;
import be.busi.pizzaland.dataAccess.util.ProviderConverter;
import be.busi.pizzaland.model.Commande;
import be.busi.pizzaland.model.EtatCommande;
import be.busi.pizzaland.model.EtatCommandeEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CommandeDAO {

    @Autowired
    private ProviderConverter providerConverter;
    @Autowired
    private EtatCommandeRepository etatCommandeRepository;
    @Autowired
    private CommandeRepository commandeRepository;

    public Commande save(Commande commande) {

        EtatCommande etatCommande =
                 providerConverter.etatCommandeEntityToEtatCommande(
                                       etatCommandeRepository.findAll()
                                       .stream()
                                       .filter(etatCommandeEntity ->
                                               etatCommandeEntity.getEtatCommande().equals(EtatCommandeEnum.NON_PAYE)
                                       ).findFirst().get());
        commande.setEtatCommande(etatCommande);
        CommandeEntity commandeEntity  = providerConverter.CommandeToComandeEntity(commande);
        CommandeEntity commandeEntitySaved = commandeRepository.save(commandeEntity);
        return providerConverter.commandeEntityToCommande(commandeEntitySaved);

    }
}
