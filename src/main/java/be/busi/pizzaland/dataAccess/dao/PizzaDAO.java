package be.busi.pizzaland.dataAccess.dao;

import be.busi.pizzaland.dataAccess.entity.CategorieEntity;
import be.busi.pizzaland.dataAccess.entity.PizzaEntity;
import be.busi.pizzaland.dataAccess.repository.CategorieRepository;
import be.busi.pizzaland.dataAccess.repository.PizzaRepository;
import be.busi.pizzaland.model.CategorieEnum;
import be.busi.pizzaland.model.Pizza;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import be.busi.pizzaland.dataAccess.util.ProviderConverter;
import java.util.Set;
import java.util.HashSet;
import java.util.stream.Collectors;

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
        Set<PizzaEntity> pizzaEntities = pizzaRepository.findAll().stream().collect(Collectors.toSet());
        Set<Pizza> pizzas = new HashSet<>();
        pizzas = pizzaRepository.findAll().
                stream().
                map(pizzaEntity -> providerConverter.PizzaEntityToPizzaModel(pizzaEntity)).
                collect(Collectors.toSet());
        return pizzas;
    }

    public Pizza save(Pizza pizza) {

        CategorieEntity categorieEntity = categorieRepository.
                save(providerConverter.categorieEnumToCategorie(pizza.getCategorie()));



        PizzaEntity pizzaEntity = providerConverter.PizzaModelToPizzaEntity(pizza);
        pizzaEntity.setCategorie(categorieEntity);
        PizzaEntity pizzaSaved = pizzaRepository.save(pizzaEntity);
        Pizza pizzaToReturn = providerConverter.PizzaEntityToPizzaModel(pizzaSaved);
        return pizzaToReturn;
    }

    public Set<Pizza> pizzaByCategorie(String categorie) {

        CategorieEnum categorieEnum = CategorieEnum.valueOf(categorie);
        CategorieEntity categorieEntity = providerConverter.categorieEnumToCategorie(categorieEnum);
        Set<PizzaEntity> pizzaEntities = pizzaRepository.findByCategorieCategorieEnum(categorieEnum).stream().collect(Collectors.toSet());
        return pizzaEntities.stream().
                map(pizzaEntity -> providerConverter.PizzaEntityToPizzaModel(pizzaEntity)).
                collect(Collectors.toSet());
    }

}
