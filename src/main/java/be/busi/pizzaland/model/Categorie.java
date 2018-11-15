package be.busi.pizzaland.model;

public class Categorie {

    private Long id;
    private CategorieEnum categorie;

    public Categorie(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public CategorieEnum getCategorie() {
        return categorie;
    }

    public void setCategorie(CategorieEnum categorie) {
        this.categorie = categorie;
    }
}
