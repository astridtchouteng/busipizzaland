package be.busi.pizzaland.dataAccess.entity;

import be.busi.pizzaland.model.CategorieEnum;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "categorie")
public class CategorieEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "categorie", unique = true)
    @NotNull
    @Enumerated(value = EnumType.STRING)
    private CategorieEnum categorieEnum;

    @OneToMany(mappedBy = "categorie",
            fetch = FetchType.EAGER,
            cascade = CascadeType.MERGE)
    private List<PizzaEntity> pizzas;


    public CategorieEntity() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public CategorieEnum getCategorieEnum() {
        return categorieEnum;
    }

    public void setCategorieEnum(CategorieEnum categorieEnum) {
        this.categorieEnum = categorieEnum;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CategorieEntity)) return false;
        CategorieEntity that = (CategorieEntity) o;
        return Objects.equals(getId(), that.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
