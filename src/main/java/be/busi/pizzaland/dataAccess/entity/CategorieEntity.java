package be.busi.pizzaland.dataAccess.entity;

import be.busi.pizzaland.model.CategorieEnum;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name = "categorie")
public class CategorieEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "categorie", unique = true)
    @NotNull
    private CategorieEnum categorieEnum;

    @OneToMany(mappedBy = "categorieEntity",
            fetch = FetchType.EAGER,
            cascade = CascadeType.ALL)
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
}
