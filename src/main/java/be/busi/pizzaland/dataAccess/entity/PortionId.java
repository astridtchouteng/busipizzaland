package be.busi.pizzaland.dataAccess.entity;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Embeddable
public class PortionId implements Serializable {

    @Column(name = "pizza_id", insertable = false, updatable = false)
    private Long pizza;

    @Column(name = "ingredient_id", insertable = false, updatable = false)
    private Long ingredient;

    public void setPizzaEntity(Long pizzaId) {
        this.pizza = pizzaId;
    }

    public void setIngredientEntity(Long ingredientId) {
        this.ingredient = ingredientId;
    }

    public Long getPizzaEntity() {
        return pizza;
    }

    public Long getIngredientEntity() {
        return ingredient;
    }
}
