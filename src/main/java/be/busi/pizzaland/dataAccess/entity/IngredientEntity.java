package be.busi.pizzaland.dataAccess.entity;


import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "ingredient")
public class IngredientEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "nom", unique = true)
    private String nom;

    @NotNull
    @Column(name = "stock")
    private double stock;

    @OneToMany(mappedBy = "primaryKey.ingredient",
            fetch = FetchType.LAZY,
            cascade = CascadeType.MERGE)//cascade for this case is required
    private Set<PortionEntity> portions = new HashSet<>();

    public IngredientEntity() {
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

    public double getStock() {
        return stock;
    }

    public void setStock(double stock) {
        this.stock = stock;
    }

    public Set<PortionEntity> getPortions() {
        return portions;
    }

    public void setPortions(Set<PortionEntity> portions) {
        this.portions = portions;
    }

    public void addPortion(PortionEntity portionEntity){
        this.portions.add(portionEntity);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof IngredientEntity)) return false;
        IngredientEntity that = (IngredientEntity) o;
        return Objects.equals(getId(), that.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
