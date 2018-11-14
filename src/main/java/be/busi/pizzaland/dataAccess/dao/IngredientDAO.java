package be.busi.pizzaland.dataAccess.dao;


import be.busi.pizzaland.dataAccess.repository.IngredientRepository;
import be.busi.pizzaland.dataAccess.util.ProviderConverter;
import be.busi.pizzaland.model.Ingredient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class IngredientDAO {

    @Autowired
    private IngredientRepository ingredientRepository;

    @Autowired
    private ProviderConverter providerConverter;

    public List<Ingredient> getAllIngredients(){

        List<Ingredient> ingredients = new ArrayList<>();
        ingredients =   ingredientRepository.findAll()
                            .stream()
                            .map(ingredientEntity ->
                                    providerConverter.ingredientEntityToIngredient(ingredientEntity))
                            .collect(Collectors.toList());

        return  ingredients;
    }


    public Ingredient getIngredientById(Long id){
        return providerConverter.ingredientEntityToIngredient(ingredientRepository.findOne(id));
    }
}
