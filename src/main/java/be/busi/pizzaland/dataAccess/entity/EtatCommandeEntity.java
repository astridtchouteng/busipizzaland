package be.busi.pizzaland.dataAccess.entity;

import be.busi.pizzaland.model.EtatCommande;
import be.busi.pizzaland.model.EtatCommandeEnum;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "etatcommande")
public class EtatCommandeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "etat", unique = true)
    @NotNull
    @Enumerated(value = EnumType.STRING)
    private EtatCommandeEnum etatCommande;

    @OneToMany(mappedBy = "etat",
            fetch = FetchType.EAGER,
            cascade = CascadeType.ALL)
    private Set<CommandeEntity> commandeEntities;

    public EtatCommandeEntity() {
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public EtatCommandeEnum getEtatCommande() {
        return etatCommande;
    }

    public void setEtatCommande(EtatCommandeEnum etatCommande) {
        this.etatCommande = etatCommande;
    }

    public Set<CommandeEntity> getCommandeEntities() {
        return commandeEntities;
    }

    public void setCommandeEntities(Set<CommandeEntity> commandeEntities) {
        this.commandeEntities = commandeEntities;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof EtatCommandeEntity)) return false;
        EtatCommandeEntity that = (EtatCommandeEntity) o;
        return Objects.equals(getId(), that.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }


}
