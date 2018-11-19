package be.busi.pizzaland.dataAccess.dao;

import be.busi.pizzaland.dataAccess.entity.CategorieEntity;
import be.busi.pizzaland.dataAccess.entity.PizzaEntity;
import be.busi.pizzaland.dataAccess.entity.PortionEntity;
import be.busi.pizzaland.dataAccess.entity.PortionId;
import be.busi.pizzaland.dataAccess.repository.CategorieRepository;
import be.busi.pizzaland.dataAccess.repository.IngredientRepository;
import be.busi.pizzaland.dataAccess.repository.PizzaRepository;
import be.busi.pizzaland.dataAccess.repository.PortionRepository;
import be.busi.pizzaland.model.Categorie;
import be.busi.pizzaland.model.CategorieEnum;
import be.busi.pizzaland.model.Ingredient;
import be.busi.pizzaland.model.Pizza;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import be.busi.pizzaland.dataAccess.util.ProviderConverter;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.HashSet;
import java.util.stream.Collectors;

@Service
@Transactional
public class PizzaDAO {

    @Autowired
    private PizzaRepository pizzaRepository;

    @Autowired
    private PortionRepository portionRepository;

    @Autowired
    private IngredientRepository ingredientRepository;

    @Autowired
    private CategorieRepository categorieRepository;

    @Autowired
    private ProviderConverter providerConverter;

    public Set<Pizza> getAll() {
        Set<Pizza> pizzas = new HashSet<>();
        pizzas = pizzaRepository.findAll()
                .stream()
                .filter(pizzaEntity ->
                        !pizzaEntity.getCategorie().getCategorieEnum().equals(CategorieEnum.CUSTOMISEE))
                .map(pizzaEntity -> providerConverter.pizzaEntityToPizzaModel(pizzaEntity)).
                collect(Collectors.toSet());
        return pizzas;
    }

    public Pizza save(Pizza pizza) {

        PizzaEntity pizzaEntity = providerConverter.pizzaModelToPizzaEntity(pizza);
        PizzaEntity pizzaSaved = pizzaRepository.save(pizzaEntity);
        Pizza pizzaToReturn = providerConverter.pizzaEntityToPizzaModel(pizzaSaved);
        return pizzaToReturn;
    }

    public Set<Pizza> pizzaByCategorie(String categorie) {

        CategorieEntity categorieEntity =
                categorieRepository.findByCategorieEnum(CategorieEnum.valueOf(categorie));
        List<PizzaEntity> pizzaEntities2 = pizzaRepository.findByCategorie(categorieEntity);
        Set<PizzaEntity> pizzaEntities = pizzaRepository.findByCategorie(categorieEntity)
                                                        .stream().collect(Collectors.toSet());
        return pizzaEntities.stream().
                map(pizzaEntity -> providerConverter.pizzaEntityToPizzaModel(pizzaEntity)).
                collect(Collectors.toSet());
    }

    public Pizza getPizzaByNom(String nom) {

        Pizza pizza = new Pizza();
        PizzaEntity pizzaEntity = pizzaRepository.findByNom(nom);
        pizza = providerConverter.pizzaEntityToPizzaModel(pizzaEntity);
        return pizza;
    }

    public Pizza getPizzaById(Long idPizza) {
        return providerConverter.pizzaEntityToPizzaModel(pizzaRepository.findOne(idPizza));
    }

    public Pizza savePizzaCustom(Pizza pizza) {

        pizza.setCategorie(providerConverter.categorieEntityToCategorie
                                (categorieRepository.findByCategorieEnum(CategorieEnum.CUSTOMISEE)));
        PizzaEntity pizzaEntity = providerConverter.pizzaModelToPizzaEntity(pizza);

        pizzaEntity = pizzaRepository.save(pizzaEntity);

        for (Map.Entry<Ingredient, Integer> entry: pizza.getMapIngredients().entrySet() ) {
            PortionId portionId = new PortionId();
            portionId.setPizzaEntity(pizzaEntity.getId());
            portionId.setIngredientEntity(entry.getKey().getId());
            PortionEntity portionEntity = new PortionEntity();
            portionEntity.setPrimaryKey(portionId);
            portionEntity.setPortion(entry.getValue());
            portionRepository.save(portionEntity);
        }

        return providerConverter.pizzaEntityToPizzaModel(pizzaEntity);
    }
}
