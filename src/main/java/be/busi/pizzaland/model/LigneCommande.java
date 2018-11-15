package be.busi.pizzaland.model;

import java.util.Map;
import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LigneCommande)) return false;
        LigneCommande that = (LigneCommande) o;
        return getQuantite() == that.getQuantite() &&
                Objects.equals(getIdPizza(), that.getIdPizza()) &&
                Objects.equals(getIdCommande(), that.getIdCommande());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getIdPizza(), getIdCommande(), getQuantite());
    }
}
