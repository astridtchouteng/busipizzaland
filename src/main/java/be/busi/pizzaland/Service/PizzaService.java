package be.busi.pizzaland.Service;

import be.busi.pizzaland.model.Pizza;
import org.springframework.stereotype.Service;

@Service
public class PizzaService {

     static int count=1;

     public String getNomPizza(){
         return "Custom"+count;
     }

     public String getDescriptionPizza(){
         return "Description"+count++;
     }

     public Double getPrixPizza(Pizza pizza){


         int size = pizza.getMapIngredients().size();
         return size*3.5;
     }
}
