package be.busi.pizzaland.dataAccess.dao;

import be.busi.pizzaland.dataAccess.entity.IngredientEntity;
import be.busi.pizzaland.dataAccess.entity.PizzaEntity;
import be.busi.pizzaland.dataAccess.entity.PortionEntity;
import be.busi.pizzaland.dataAccess.repository.IngredientRepository;
import be.busi.pizzaland.dataAccess.repository.PizzaRepository;
import be.busi.pizzaland.dataAccess.repository.PortionRepository;
import be.busi.pizzaland.dataAccess.util.ProviderConverter;
import be.busi.pizzaland.model.Ingredient;
import be.busi.pizzaland.model.Pizza;
import be.busi.pizzaland.model.Portion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.stream.Collectors;

@Service
@Transactional
public class PortionDAO {

    @Autowired
    private ProviderConverter providerConverter;
    @Autowired
    private PortionRepository portionRepository;
    @Autowired
    private PizzaRepository pizzaRepository;
    @Autowired
    private IngredientRepository ingredientRepository;

    public Set<Ingredient> getIngredientByPizzaNom(String nom){
        List<IngredientEntity> ingredients = new ArrayList<>();
        PizzaEntity pizzaEntity = pizzaRepository.findByNom(nom);
        List<PortionEntity> portionEntities = new ArrayList<>();
        portionEntities = portionRepository.findAll()
                                            .stream()
                                            .filter(portionEntity ->
                                                portionEntity.getPrimaryKey()
                                                        .getPizzaEntity()
                                                        .equals(pizzaEntity.getId())
                                            )
                                            .collect(Collectors.toList());
        ingredients = portionEntities.stream()
                                     .map(portionEntity -> {
                                         Long id = portionEntity.getPrimaryKey().getIngredientEntity();
                                         return ingredientRepository.findOne(id);
                                     })
                                    .collect(Collectors.toList());
        return  ingredients.stream()
                .map(ingredientEntity ->
                        providerConverter.ingredientEntityToIngredient(ingredientEntity))
                .collect(Collectors.toSet());
    }

    public Set<Ingredient> getIngredientByPizzaId(Long idPizza) {
        List<IngredientEntity> ingredients = new ArrayList<>();
        List<PortionEntity> portionEntities = new ArrayList<>();
        portionEntities = portionRepository.findAll()
                .stream()
                .filter(portionEntity ->
                        portionEntity.getPrimaryKey()
                                .getPizzaEntity()
                                .equals(idPizza)
                )
                .collect(Collectors.toList());
        ingredients = portionEntities.stream()
                .map(portionEntity -> {
                    Long id = portionEntity.getPrimaryKey().getIngredientEntity();
                    return ingredientRepository.findOne(id);
                })
                .collect(Collectors.toList());
        return  ingredients.stream()
                .map(ingredientEntity ->
                        providerConverter.ingredientEntityToIngredient(ingredientEntity))
                .collect(Collectors.toSet());
    }


    public Pizza getIngredientPortionByIdPizza(Long idPizza){
        PizzaEntity pizzaEntity = pizzaRepository.findOne(idPizza);
        Set<PortionEntity> portionEntities = new HashSet<>();
        portionEntities = portionRepository.findAll()
                .stream()
                .filter(portionEntity ->
                        portionEntity.getPrimaryKey()
                                .getPizzaEntity()
                                .equals(pizzaEntity.getId())
                )
                .collect(Collectors.toSet());
        Map<Ingredient, Integer> maps = new HashMap<>();
        portionEntities.stream()
                        .forEach(portionEntity -> {
                            Long id = portionEntity.getPrimaryKey().getIngredientEntity();
                            IngredientEntity ingredientEntity = ingredientRepository.findOne(id);
                            Ingredient ingredient = providerConverter.ingredientEntityToIngredient(ingredientEntity);
                            maps.put(ingredient, portionEntity.getPortion());
                        });

        Pizza pizza = providerConverter.pizzaEntityToPizzaModel(pizzaEntity);
        pizza.setMapIngredients(maps);
        return pizza;
    }


    public List<Portion> findPortionbyPizzaId(Long idPizza) {

        List<PortionEntity> portionEntities = portionRepository.findByPrimaryKey_Pizza(idPizza);

        return portionEntities.stream()
                .map(portionEntity -> providerConverter.portionEntityToPortion(portionEntity))
                .collect(Collectors.toList());
    }
}
