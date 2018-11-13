package be.busi.pizzaland.dataAccess.entity;


import org.springframework.stereotype.Component;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "pizza")
public class PizzaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JoinColumn(name = "categorie",
            referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private CategorieEntity categorie;

    @Column(name = "description")
    private String description;

    @NotNull
    @Column(name = "nom", unique = true)
    private String nom;

    @NotNull
    @Column(name = "prix")
    private double prix;

    @OneToMany(mappedBy = "primaryKey.pizza",
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private Set<PortionEntity> portions = new HashSet<>();


    @OneToMany(
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL,
            mappedBy = "primaryKey.pizza")
    private Set<LigneCommandeEntity> ligneCommandes = new HashSet<>();


    public PizzaEntity() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public CategorieEntity getCategorie() {
        return categorie;
    }

    public void setCategorie(CategorieEntity categorie) {
        this.categorie = categorie;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public Set<PortionEntity> getPortions() {
        return portions;
    }

    public void setPortions(Set<PortionEntity> portions) {
        this.portions = portions;
    }

    public Set<LigneCommandeEntity> getLigneCommandes() {
        return ligneCommandes;
    }

    public void setLigneCommandes(Set<LigneCommandeEntity> ligneCommandes) {
        this.ligneCommandes = ligneCommandes;
    }

    public void addPortion(PortionEntity portionEntity){
        this.portions.add(portionEntity);
    }

    public void addLigneCommande(LigneCommandeEntity ligneCommandeEntity){
        this.ligneCommandes.add(ligneCommandeEntity);
    }
}
