package be.busi.pizzaland.dataAccess.entity;


import be.busi.pizzaland.model.EtatCommandeEnum;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Objects;
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
    private EtatCommandeEnum etat;

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

    public EtatCommandeEnum getEtat() {
        return etat;
    }

    public void setEtat(EtatCommandeEnum etat) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CommandeEntity)) return false;
        CommandeEntity that = (CommandeEntity) o;
        return Objects.equals(getId(), that.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
