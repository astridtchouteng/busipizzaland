package be.busi.pizzaland.controller;

import be.busi.pizzaland.service.PizzaService;
import be.busi.pizzaland.dataAccess.dao.IngredientDAO;
import be.busi.pizzaland.dataAccess.dao.PizzaDAO;
import be.busi.pizzaland.dataAccess.dao.PortionDAO;
import be.busi.pizzaland.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Controller
@RequestMapping(value = "/pizzaCustom")
//je dois passer le panier aussi
@SessionAttributes({Constants.INGREDIENTS_PIZZA, Constants.PANIER})
public class PizzaCustomController {

    @Autowired
    private PizzaService pizzaService;

    @Autowired
    private PizzaDAO pizzaDAO;

    @Autowired
    private PortionDAO portionDAO;

    @ModelAttribute(Constants.INGREDIENTS_PIZZA)
    public Map<Ingredient, Integer> ingredients(){
        return new HashMap<>();
    }

    @ModelAttribute(Constants.PANIER)
    public Panier panier(){
        return new Panier();
    }

    @Autowired
    private IngredientDAO ingredientDAO;

    @RequestMapping( method = RequestMethod.GET)
    public String pizzaParCategorie(@RequestParam(name = "idIngredient", required = false)
                                                Long idIngredient,
                                    Model model,
                                    @ModelAttribute(value = Constants.INGREDIENTS_PIZZA)
                                                Map<Ingredient, Integer> ingredients) {

        if(idIngredient != null) {
            Ingredient ingredient = ingredientDAO.getIngredientById(idIngredient);
            if(ingredient.getStock()<1){
            }
            else{
                if (!ingredients.containsKey(ingredient)) {
                    ingredients.put(ingredient,1);
                }else{
                    for (Map.Entry<Ingredient, Integer> entry: ingredients.entrySet() ) {
                        if(entry.getKey().getId().equals(ingredient.getId())){
                            entry.setValue(entry.getValue()+1);
                        }
                    }
                }
                ingredient.setStock(ingredient.getStock()-1);
                ingredientDAO.updateStock(ingredient);

            }
        }

        model.addAttribute("pizza", new Pizza());
        model.addAttribute(Constants.INGREDIENTS_PIZZA, ingredients);
        List<Ingredient> allIngredients = ingredientDAO.getIngredientStock();
        model.addAttribute("ingredients",allIngredients);
        return "integrated:pizzaCustom";

    }

    @RequestMapping(method = RequestMethod.POST)
    public String postPizzaCustom(
                                  @ModelAttribute(value = "pizza") Pizza pizza,
                                  @ModelAttribute(value = Constants.INGREDIENTS_PIZZA)
                                          Map<Ingredient, Integer> ingredients,
                                  Model model,
                                  Authentication authentication,
                                  @ModelAttribute(value = Constants.PANIER) Panier panier){


        pizza.setMapIngredients(ingredients);
        pizza.setNom(pizzaService.getNomPizza());
        pizza.setDescription(pizzaService.getDescriptionPizza());
        pizza.setPrix(pizzaService.getPrixPizza(pizza));
        //je dois save cette pizz    avec la categorie CUSTOMISEE
        pizza = pizzaDAO.savePizzaCustom(pizza);
        //je l'ajoute au panier
        panier.addPizza(pizza,1);
        model.addAttribute(Constants.INGREDIENTS_PIZZA, new HashMap<>());
        return "redirect:/home";
    }

 /*   @RequestMapping(value = "/plus", method = RequestMethod.GET)
    public String plus(@RequestParam(name = "idPizza") Long idPizza,
                       @RequestParam(name = "idIngredient") Long idIngredient,
                       Model model,
                       @ModelAttribute(value = Constants.INGREDIENTS_PIZZA)
                                   Map<Ingredient, Integer> ingredients){
        Pizza pizza = portionDAO.getIngredientPortionByIdPizza(idPizza)
                ;
        Ingredient ingredient = ingredientDAO.getIngredientById(idIngredient);
        pizza.addIngredient(ingredient);
        model.addAttribute(Constants.INGREDIENTS_PIZZA , pizza.getMapIngredients());
        return "redirect:/pizzaDetails?idPizza="+idPizza;
    }



    @RequestMapping(value = "/moins", method = RequestMethod.GET)
    public String Moins(@RequestParam(name = "idPizza") Long idPizza,
                        @RequestParam(name = "idIngredient", required = false) Long idIngredient,
                        Model model,
                        @ModelAttribute(value = Constants.INGREDIENTS_PIZZA)
                                    Map<Ingredient, Integer> ingredients){

        Pizza pizza = portionDAO.getIngredientPortionByIdPizza(idPizza);
        Ingredient ingredient = ingredientDAO.getIngredientById(idIngredient);
        pizza.removeIngredient(ingredient);
        model.addAttribute(Constants.INGREDIENTS_PIZZA , pizza.getMapIngredients());
        return "redirect:/pizzaDetails?idPizza="+idPizza;
    }
*/

















}
