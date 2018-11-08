package be.busi.pizzaland.dataAccess.entity;

import javax.persistence.*;
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
    private Double portion;

    public PortionEntity() {}

    public PortionId getPrimaryKey() {
        return primaryKey;
    }

    public Double getPortion() {
        return portion;
    }

    public void setPrimaryKey(PortionId primaryKey) {
        this.primaryKey = primaryKey;
    }

    public void setPortion(Double portion) {
        this.portion = portion;
    }


}
