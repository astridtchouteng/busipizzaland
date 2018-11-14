package be.busi.pizzaland.model;


import java.util.*;


public class Pizza {

    private Long id;
    private Categorie categorie;
    private String description;
    private double prix;
    private String nom;
    List<String> stringIngredients = new ArrayList<>();
    Map<Ingredient, Integer> mapIngredients = new HashMap<>();

    public Pizza() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Set<Ingredient> getIngredients() {
        return mapIngredients.keySet();
    }

    public List<String> getStringIngredients() {
        return stringIngredients;
    }

    public void setStringIngredients(List<String> stringIngredients) {
        this.stringIngredients = stringIngredients;
    }

    public Map<Ingredient, Integer> getMapIngredients() {
        return mapIngredients;
    }

    public void setMapIngredients(Map<Ingredient, Integer> mapIngredients) {
        this.mapIngredients = mapIngredients;
    }

    public void addIngredient(Ingredient ingredient){

        for (Map.Entry<Ingredient, Integer> entry: mapIngredients.entrySet() ) {
            if(entry.getKey().getId().equals(ingredient.getId())){
                entry.setValue(entry.getValue()+1);
                break;
            }
        }

        if(!mapIngredients.containsKey(ingredient)) {
            mapIngredients.put(ingredient,1);
        }
    }

    public void removeIngredient(Ingredient ingredient){
        for (Map.Entry<Ingredient, Integer> entry: mapIngredients.entrySet() ) {
            if(entry.getKey().getId().equals(ingredient.getId())){
                if(entry.getValue().equals(1)){
                    mapIngredients.remove(ingredient);
                }
                else{
                    entry.setValue(entry.getValue()-1);
                }
            }
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Pizza)) return false;
        Pizza pizza = (Pizza) o;
        return Objects.equals(getNom(), pizza.getNom());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNom());
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
