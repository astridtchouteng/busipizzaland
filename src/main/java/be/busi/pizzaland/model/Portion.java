package be.busi.pizzaland.model;

import java.util.Objects;

public class Portion {

    private Long idIngredient;
    private Long idPizza;
    private int portion;

    public Portion(Long idIngredient, Long idPizza, int portion) {
        this.idIngredient = idIngredient;
        this.idPizza = idPizza;
        this.portion = portion;
    }

    public Portion() {
    }

    public Long getIdIngredient() {
        return idIngredient;
    }

    public void setIdIngredient(Long idIngredient) {
        this.idIngredient = idIngredient;
    }

    public Long getIdPizza() {
        return idPizza;
    }

    public void setIdPizza(Long idPizza) {
        this.idPizza = idPizza;
    }

    public int getPortion() {
        return portion;
    }

    public void setPortion(int portion) {
        this.portion = portion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Portion)) return false;
        Portion portion1 = (Portion) o;
        return getPortion() == portion1.getPortion() &&
                Objects.equals(getIdIngredient(), portion1.getIdIngredient()) &&
                Objects.equals(getIdPizza(), portion1.getIdPizza());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getIdIngredient(), getIdPizza(), getPortion());
    }

    @Override
    public String toString() {
        return "Portion{" +
                "idIngredient=" + idIngredient +
                ", idPizza=" + idPizza +
                ", portion=" + portion +
                '}';
    }
}
