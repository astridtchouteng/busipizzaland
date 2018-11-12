package be.busi.pizzaland.model;

public class Commande {

    private EtatCommande etatCommande;

    private User user;

    public Commande() {
    }

    public Commande(EtatCommande etatCommande) {
        this.etatCommande = etatCommande;
    }

    public Commande(EtatCommande etatCommande, User user) {
        this.etatCommande = etatCommande;
        this.user = user;
    }

    public EtatCommande getEtatCommande() {
        return etatCommande;
    }

    public void setEtatCommande(EtatCommande etatCommande) {
        this.etatCommande = etatCommande;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
