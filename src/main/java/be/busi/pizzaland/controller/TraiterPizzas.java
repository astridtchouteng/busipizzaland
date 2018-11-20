package be.busi.pizzaland.controller;


import be.busi.pizzaland.Service.PanierService;
import be.busi.pizzaland.dataAccess.dao.IngredientDAO;
import be.busi.pizzaland.dataAccess.dao.PizzaDAO;
import be.busi.pizzaland.dataAccess.dao.PortionDAO;
import be.busi.pizzaland.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "/traiter")
@SessionAttributes({Constants.PANIER, Constants.INGREDIENTS_RESTANTS})
public class TraiterPizzas {

    @Autowired
    private PanierService panierService;

    @Autowired
    private PizzaDAO pizzaDAO;

    @Autowired
    private IngredientDAO ingredientDAO;

    @Autowired
    private PortionDAO portionDAO;

    @ModelAttribute(Constants.PANIER)
    public Panier panier(){
        return new Panier();
    }

    @ModelAttribute(Constants.INGREDIENTS_RESTANTS)
    public List<Ingredient> ingredients(){
        return new ArrayList<>();
    }


    @RequestMapping(method = RequestMethod.GET)
    public String home(@RequestParam(name = "nomPizza", required = false, defaultValue = "world")String nomPizza,
                       Model model,
                       @ModelAttribute(value= Constants.PANIER) Panier panier, BindingResult errors,
                       @ModelAttribute(Constants.INGREDIENTS_RESTANTS) List<Ingredient> ingredients)  {


        Pizza pizza = pizzaDAO.getPizzaByNom(nomPizza);

        if(ingredients == null || ingredients.isEmpty()){

            ingredients = ingredientDAO.getAllIngredients();
            model.addAttribute(Constants.INGREDIENTS_RESTANTS, ingredients);
        }

        if(pizza != null){


            //si ingredient suffisant
            List<Portion> portions = portionDAO.findPortionbyPizzaId(pizza.getId());
            //List<Ingredient> ingredients = ingredientDAO.getAllIngredients();
            Map<Long,Integer> idIngredientStock = new HashMap<>();

            Boolean ok = true;
            int i=0, j=0;
            for(i=0; i<portions.size() && ok ; i++){
                for(j=0; j<ingredients.size() && ok; j++){
                    if(portions.get(i).getIdIngredient().equals(ingredients.get(j).getId()) &&
                            portions.get(i).getPortion() > ingredients.get(j).getStock()){
                        ok=false;
                    }
                }
                if(!ok){
                    panier.setMonStock("Pas de Stock");
                    return "redirect:/panier";
                }
                idIngredientStock.put(portions.get(i).getIdIngredient(), portions.get(i).getPortion());
            }
            //les portions sont bonnes et je dois diminuer les stocks

            for (Map.Entry<Long, Integer> key : idIngredientStock.entrySet()) {
                for(Ingredient ingredient : ingredients)
                    if(ingredient.getId().equals(key.getKey()))
                        ingredient.setStock(ingredient.getStock()-key.getValue());
                //ingredientDAO.updateStock(ingredient);
            }
            panier.addPizza(pizza, 1);
        }

        /*if(pizza != null) {
            panier.addPizza(pizza, 1);
        }*/
        model.addAttribute(Constants.PANIER, panier);

        if(errors.hasErrors()){

            return "redirect:/affciherPizzas";
        }

        System.out.println(ingredients);

        return "redirect:/panier";
    }

}
