package be.busi.pizzaland.model;

import java.util.HashMap;
import java.util.Map;

public class Panier {

    private Map<Pizza, Integer> contenu = new HashMap<>();

    private int quantiteTotal;

    private int prixTotal;

    public Panier() {

        this.quantiteTotal = 0;
        this.prixTotal = 0;
    }

    public void addPizza(Pizza pizza, int quantite) {

        if(!contenu.containsKey(pizza)){
            contenu.put(pizza, 1);
        }
        else {
            contenu.put(pizza, contenu.get(pizza) + quantite);
        }

        this.quantiteTotal += quantite;

        updatePriTolal();
    }

    public boolean containsKey(Pizza pizza) {

        return contenu.containsKey(pizza);
    }

    public Integer get(Pizza pizza) {

        return contenu.get(pizza);
    }

    private void updatePriTolal() {

        this.prixTotal = 0;

        for(Pizza pizza : contenu.keySet())
            this.prixTotal += pizza.getPrix() * contenu.get(pizza);
    }

    public Map<Pizza, Integer> getContenu() {
        return contenu;
    }

    public void setContenu(Map<Pizza, Integer> contenu) {
        this.contenu = contenu;
    }

    public int getQuantiteTotal() {
        return quantiteTotal;
    }

    public void setQuantiteTotal(int quantiteTotal) {
        this.quantiteTotal = quantiteTotal;
    }

    public int getPrixTotal() {
        return prixTotal;
    }

    public void setPrixTotal(int prixTotal) {
        this.prixTotal = prixTotal;
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
