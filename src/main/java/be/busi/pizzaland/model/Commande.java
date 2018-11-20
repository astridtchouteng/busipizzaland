package be.busi.pizzaland.model;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

public class Commande {

    private  Long id;
    private EtatCommande etatCommande;

    private User user;

    private Set<LigneCommande> ligneCommandes = new HashSet<>();

    private LocalDateTime heure;

    private Double price;

    public Commande() {
        this.heure = LocalDateTime.now();
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Commande(Long id, EtatCommande etatCommande, User user, Set<LigneCommande> ligneCommandes) {
        this.id = id;
        this.etatCommande = etatCommande;
        this.user = user;
        this.ligneCommandes = ligneCommandes;
    }

    public Commande(EtatCommande etatCommande, User user) {
        this.etatCommande = etatCommande;
        this.user = user;
    }

    public LocalDateTime getHeure() {
        return heure;
    }

    public void setHeure(LocalDateTime heure) {
        this.heure = heure;
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

    public Set<LigneCommande> getLigneCommandes() {
        return ligneCommandes;
    }

    public void setLigneCommandes(Set<LigneCommande> ligneCommandes) {
        this.ligneCommandes = ligneCommandes;
    }
}
