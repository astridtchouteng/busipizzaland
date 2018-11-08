package be.busi.pizzaland.dataAccess.entity;


import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class LigneCommandeId implements Serializable {

    @Column(name = "pizza_id", insertable = false, updatable = false)
    private Long pizza;

    @Column(name = "commande_id", insertable = false, updatable = false)
    private Long commande;

    public Long getPizza() {
        return pizza;
    }

    public void setPizza(Long pizza) {
        this.pizza = pizza;
    }

    public Long getCommande() {
        return commande;
    }

    public void setCommande(Long commande) {
        this.commande = commande;
    }
}
