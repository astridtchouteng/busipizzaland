package be.busi.pizzaland.dataAccess.entity;


import be.busi.pizzaland.model.EtatCommande;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "commandes")
public class CommandeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JoinColumn(name = "userCommandes",
            referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.EAGER)
    private UserEntity user;

    @Column(name = "etat")
    @NotNull
    @Enumerated(value = EnumType.STRING)
    private EtatCommande etat;

    @OneToMany(fetch = FetchType.LAZY,
            cascade = CascadeType.ALL,
            mappedBy = "primaryKey.commande")
    private Set<LigneCommandeEntity> ligneCommandes = new HashSet<>();

    public CommandeEntity(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    public EtatCommande getEtat() {
        return etat;
    }

    public void setEtat(EtatCommande etat) {
        this.etat = etat;
    }

    public Set<LigneCommandeEntity> getLigneCommandes() {
        return ligneCommandes;
    }

    public void setLigneCommandes(Set<LigneCommandeEntity> ligneCommandes) {
        this.ligneCommandes = ligneCommandes;
    }

    public void addLigneCommande(LigneCommandeEntity ligneCommandeEntity){
        this.ligneCommandes.add(ligneCommandeEntity);
    }
}
