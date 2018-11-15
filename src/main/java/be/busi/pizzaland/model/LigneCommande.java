package be.busi.pizzaland.model;

import java.util.Map;

public class LigneCommande {

    private int quantite;
    private String nom;



    public LigneCommande() {
    }

    public LigneCommande(int quantite) {
        this.quantite = quantite;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }
}
