package be.busi.pizzaland.dataAccess.dao;

import be.busi.pizzaland.dataAccess.Util.ProviderConverter;
import be.busi.pizzaland.dataAccess.entity.CategorieEntity;
import be.busi.pizzaland.dataAccess.entity.PizzaEntity;
import be.busi.pizzaland.dataAccess.repository.CategorieRepository;
import be.busi.pizzaland.dataAccess.repository.PizzaRepository;
import be.busi.pizzaland.model.Pizza;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

@Service
@Transactional
public class PizzaDAO {

    @Autowired
    private PizzaRepository pizzaRepository;

    @Autowired
    private CategorieRepository categorieRepository;

    @Autowired
    private ProviderConverter providerConverter;

    public Set<Pizza> getAll() {

        return null;
    }

    public Pizza save(Pizza pizza) {

        CategorieEntity categorieEntity = categorieRepository.
                save(providerConverter.categorieEnumToCategorieEntity(pizza.getCategorie()));



        PizzaEntity pizzaEntity = providerConverter.pizzaModelToPizzaEntity(pizza);
        pizzaEntity.setCategorie(categorieEntity);
        PizzaEntity pizzaSaved = pizzaRepository.save(pizzaEntity);
        Pizza pizzaToReturn = providerConverter.pizzaEntityToPizzaModel(pizzaSaved);
        return pizzaToReturn;
    }
}
