package be.busi.pizzaland.dataAccess.entity;


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
    private CategorieEntity categorieEntity;

    @Column(name = "description")
    private String description;

    @NotNull
    @Column(name = "prix")
    private double prix;

    @OneToMany(mappedBy = "primaryKey.pizza",
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private Set<PortionEntity> portionEntities = new HashSet<>();


    public PizzaEntity() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public CategorieEntity getCategorieEntity() {
        return categorieEntity;
    }

    public void setCategorieEntity(CategorieEntity categorieEntity) {
        this.categorieEntity = categorieEntity;
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
}
