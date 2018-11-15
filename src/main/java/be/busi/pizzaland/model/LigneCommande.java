package be.busi.pizzaland.model;

import java.util.Map;

public class LigneCommande {

    private int idPizza;
    private int idCommande;
    private int quantite;


    public LigneCommande() {
    }

    public LigneCommande(int quantite) {
        this.quantite = quantite;
    }

    public int getIdPizza() {
        return idPizza;
    }

    public void setIdPizza(int idPizza) {
        this.idPizza = idPizza;
    }

    public int getIdCommande() {
        return idCommande;
    }

    public void setIdCommande(int idCommande) {
        this.idCommande = idCommande;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }
}
