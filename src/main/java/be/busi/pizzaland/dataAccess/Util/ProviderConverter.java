package be.busi.pizzaland.dataAccess.Util;

import be.busi.pizzaland.dataAccess.entity.CategorieEntity;
import be.busi.pizzaland.dataAccess.entity.PizzaEntity;
import be.busi.pizzaland.model.CategorieEnum;
import be.busi.pizzaland.model.Pizza;
import org.springframework.stereotype.Component;

@Component
public class ProviderConverter {

    public PizzaEntity pizzaModelToPizzaEntity(Pizza pizza) {

        PizzaEntity pizzaEntity = new PizzaEntity();

        pizzaEntity.setCategorie(categorieEnumToCategorieEntity(pizza.getCategorie()));
        pizzaEntity.setDescription(pizza.getDescription());
        pizzaEntity.setPrix(pizza.getPrix());

        return pizzaEntity;
    }

    public Pizza pizzaEntityToPizzaModel(PizzaEntity pizzaEntity) {

        Pizza pizza = new Pizza();

        pizza.setCategorie(pizzaEntity.getCategorie().getCategorieEnum());
        pizza.setDescription(pizzaEntity.getDescription());
        pizza.setPrix(pizzaEntity.getPrix());

        return pizza;
    }

    public CategorieEnum categorieEntityToCategorieEnum(CategorieEntity categorieEntity) {

        return categorieEntity.getCategorieEnum();
    }

    public CategorieEntity categorieEnumToCategorieEntity(CategorieEnum categorieEnum) {

        CategorieEntity categorieEntity = new CategorieEntity();
        categorieEntity.setCategorieEnum(categorieEnum);

        return categorieEntity;
    }

}
