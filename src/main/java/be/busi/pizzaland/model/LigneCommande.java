package be.busi.pizzaland.model;

import java.util.Map;

public class LigneCommande {

    private Long idPizza;
    private Long idCommande;
    private int quantite;


    public LigneCommande() {
    }

    public LigneCommande(int quantite) {
        this.quantite = quantite;
    }

    public Long getIdPizza() {
        return idPizza;
    }

    public void setIdPizza(Long idPizza) {
        this.idPizza = idPizza;
    }

    public Long getIdCommande() {
        return idCommande;
    }

    public void setIdCommande(Long idCommande) {
        this.idCommande = idCommande;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }
}
