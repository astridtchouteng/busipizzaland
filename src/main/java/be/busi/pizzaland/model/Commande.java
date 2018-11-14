package be.busi.pizzaland.model;

public class Commande {

    private EtatCommandeEnum etatCommande;

    private User user;

    public Commande() {
    }

    public Commande(EtatCommandeEnum etatCommande) {
        this.etatCommande = etatCommande;
    }

    public Commande(EtatCommandeEnum etatCommande, User user) {
        this.etatCommande = etatCommande;
        this.user = user;
    }

    public EtatCommandeEnum getEtatCommande() {
        return etatCommande;
    }

    public void setEtatCommande(EtatCommandeEnum etatCommande) {
        this.etatCommande = etatCommande;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
