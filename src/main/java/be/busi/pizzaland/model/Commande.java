package be.busi.pizzaland.model;

public class Commande {

    private  Long id;
    private EtatCommande etatCommande;

    private User user;

    public Commande() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
