package be.busi.pizzaland.dataAccess.entity;

import be.busi.pizzaland.model.LocalDateConverter;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.LocalDateTime;

@Entity
@Table(name = "promotion")
public class PromotionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  Long id;

    @Column
    //@Convert(converter = LocalDateConverter.class)
    private LocalDateTime dateDebut;

    @Column
    //@Convert(converter = LocalDateConverter.class)
    private LocalDateTime dateFin;

    @Column(name = "codePromo")
    private Double montantMinimum;

    @Column(name = "pourcentage")
    private Integer pourcentage;

    public PromotionEntity() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getDateDebut() {
        return dateDebut;
    }

    public LocalDateTime getDateFin() {
        return dateFin;
    }

    public void setDateDebut(LocalDateTime dateDebut) {
        this.dateDebut = dateDebut;
    }

    public void setDateFin(LocalDateTime dateFin) {
        this.dateFin = dateFin;
    }

    public Double getMontantMinimum() {
        return montantMinimum;
    }

    public void setMontantMinimum(Double montantMinimum) {
        this.montantMinimum = montantMinimum;
    }

    public Integer getPourcentage() {
        return pourcentage;
    }

    public void setPourcentage(Integer pourcentage) {
        this.pourcentage = pourcentage;
    }
}
