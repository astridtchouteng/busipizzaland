package be.busi.pizzaland.model;

public class EtatCommande {

    private EtatCommandeEnum etatCommandeEnum;

    public EtatCommande() {
    }

    public EtatCommande(EtatCommandeEnum etatCommandeEnum) {
        this.etatCommandeEnum = etatCommandeEnum;
    }

    public EtatCommandeEnum getEtatCommandeEnum() {
        return etatCommandeEnum;
    }

    public void setEtatCommandeEnum(EtatCommandeEnum etatCommandeEnum) {
        this.etatCommandeEnum = etatCommandeEnum;
    }
}
