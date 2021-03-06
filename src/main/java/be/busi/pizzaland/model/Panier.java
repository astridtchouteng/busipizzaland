package be.busi.pizzaland.model;

import java.util.HashMap;
import java.util.Map;

public class Panier {

    private Map<Pizza, Integer> contenu = new HashMap<>();

    private int quantiteTotal;

    private Double prixTotal;

    private Double reduction;

    private String monStock;

    public Panier() {

        this.quantiteTotal = 0;
        this.prixTotal = 0.0;
    }

    public Double getReduction() {
        return reduction;
    }

    public void setReduction(Double reduction) {
        this.reduction = reduction;
    }

    public void addPizza(Pizza pizza, Integer quantite) {

        if(!contenu.containsKey(pizza)){
            contenu.put(pizza, 1);
        }
        else {
            contenu.put(pizza, contenu.get(pizza) + quantite);
        }

        this.quantiteTotal += quantite;

        updatePriTolal();
    }

    public void removePizza(Pizza pizza, Integer quantite){


        if(contenu != null && contenu.containsKey(pizza) && contenu.get(pizza) >= 1 ){

            contenu.put(pizza, contenu.get(pizza) -1);

            if(contenu.get(pizza) == 0)
                contenu.remove(pizza);

            this.quantiteTotal -= quantite;
            updatePriTolal();
        }

    }

    public void supprimerParPizza(Pizza pizza){

        int quantite = 0;

        if(contenu != null && contenu.containsKey(pizza)) {
            quantite = contenu.remove(pizza);
            this.quantiteTotal -= quantite;
            updatePriTolal();
        }
    }

    public void vider() {

        if(contenu!= null);
            contenu = new HashMap<>();
        this.quantiteTotal = 0;
        this.prixTotal = 0.0;
    }

    public boolean containsKey(Pizza pizza) {

        return contenu.containsKey(pizza);
    }

    public Integer get(Pizza pizza) {

        return contenu.get(pizza);
    }

    private void updatePriTolal() {

        this.prixTotal = 0.0;

        for(Pizza pizza : contenu.keySet())
            this.prixTotal += pizza.getPrix() * contenu.get(pizza);
    }

    public Map<Pizza, Integer> getContenu() {
        return contenu;
    }

    public void setContenu(Map<Pizza, Integer> contenu) {
        this.contenu = contenu;
    }

    public Integer getQuantiteTotal() {
        return quantiteTotal;
    }

    public void setQuantiteTotal(Integer quantiteTotal) {
        this.quantiteTotal = quantiteTotal;
    }

    public Double getPrixTotal() {
        return prixTotal;
    }

    public void setPrixTotal(Double prixTotal) {
        this.prixTotal = prixTotal;
    }

    public void setQuantiteTotal(int quantiteTotal) {
        this.quantiteTotal = quantiteTotal;
    }

    public String getMonStock() {
        return monStock;
    }

    public void setMonStock(String monStock) {
        this.monStock = monStock;
    }

    @Override
    public String toString() {
        return "Panier{" +
                "contenu=" + contenu +
                ", quantiteTotal=" + quantiteTotal +
                ", prixTotal=" + prixTotal +
                '}';
    }
}
