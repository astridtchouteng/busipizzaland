package be.busi.pizzaland.dataAccess.entity;


import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "lignecommande")
@AssociationOverrides(value = {
        @AssociationOverride(name = "primaryKey.pizza", joinColumns = {@JoinColumn(name = "id")}),
        @AssociationOverride(name = "primaryKey.commande", joinColumns = {@JoinColumn(name = "id")})
})
public class LigneCommandeEntity {

    @EmbeddedId
    private LigneCommandeId primaryKey;

    @Column(name = "quantite")
    @NotNull
    @Min(value = 1)
    private Integer quantite;

    public LigneCommandeEntity() {
    }

    public LigneCommandeId getPrimaryKey() {
        return primaryKey;
    }

    public void setPrimaryKey(LigneCommandeId primaryKey) {
        this.primaryKey = primaryKey;
    }

    public Integer getQuantite() {
        return quantite;
    }

    public void setQuantite(Integer quantite) {
        this.quantite = quantite;
    }
}
