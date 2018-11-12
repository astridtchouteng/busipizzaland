package be.busi.pizzaland.model;


import java.util.Objects;


public class Pizza {

    private Categorie categorie;
    private String description;
    private double prix;
    private String nom;
    public Pizza() {
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Categorie getCategorie() {
        return categorie;
    }

    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }


    @Override
    public String toString() {
        return "Pizza{" +
                ", categorie=" + categorie +
                ", description='" + description + '\'' +
                ", prix=" + prix +
                '}';
    }
}
