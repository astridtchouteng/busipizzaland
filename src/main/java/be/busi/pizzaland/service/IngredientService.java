package be.busi.pizzaland.service;


import be.busi.pizzaland.dataAccess.dao.IngredientDAO;
import be.busi.pizzaland.model.Ingredient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IngredientService {


    @Autowired
    private IngredientDAO ingredientDAO;

    public Ingredient getIngredient(Ingredient ingredient) {

        return ingredientDAO.getAllIngredients().stream()
                .filter(i -> i.equals(ingredient)).findFirst().get();
    }
}
