package be.busi.pizzaland.dataAccess.entity;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "portion")
@AssociationOverrides({
        @AssociationOverride(name = "primaryKey.ingredient",
                joinColumns = @JoinColumn(name = "id")),
        @AssociationOverride(name = "primaryKey.pizza",
                    joinColumns = @JoinColumn(name = "id"))

})
public class PortionEntity {

   @EmbeddedId
    private PortionId primaryKey;

    @Column(name = "portion")
    @NotNull
    @Min(value = 1)
    private Integer portion;

    public PortionEntity() {}

    public PortionId getPrimaryKey() {
        return primaryKey;
    }

    public Integer getPortion() {
        return portion;
    }

    public void setPrimaryKey(PortionId primaryKey) {
        this.primaryKey = primaryKey;
    }

    public void setPortion(Integer portion) {
        this.portion = portion;
    }

    public void getIngredient(){
        getPrimaryKey().getIngredientEntity();
    }

    public void setIngredient(IngredientEntity ingredient){
        getPrimaryKey().setIngredientEntity(ingredient.getId());
    }

    public void getPizza(){
        getPrimaryKey().getPizzaEntity();
    }

    public void setPizza(PizzaEntity pizza){
        getPrimaryKey().setIngredientEntity(pizza.getId());
    }

}
