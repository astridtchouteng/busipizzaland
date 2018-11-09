package be.busi.pizzaland.model;

import be.busi.pizzaland.dataAccess.entity.CategorieEntity;

import java.util.Objects;


public class Pizza {


    private Long id;

    private CategorieEntity categorie;

    private String description;

    private double prix;

    public Pizza() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public CategorieEntity getCategorie() {
        return categorie;
    }

    public void setCategorie(CategorieEntity categorie) {
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Pizza)) return false;
        Pizza pizza = (Pizza) o;
        return Objects.equals(getId(), pizza.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    @Override
    public String toString() {
        return "Pizza{" +
                "id=" + id +
                ", categorie=" + categorie +
                ", description='" + description + '\'' +
                ", prix=" + prix +
                '}';
    }
}
