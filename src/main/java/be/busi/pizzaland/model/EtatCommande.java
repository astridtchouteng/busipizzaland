package be.busi.pizzaland.model;

public class EtatCommande {

    private Long id;
    private EtatCommandeEnum etatCommandeEnum;

    public EtatCommande() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
