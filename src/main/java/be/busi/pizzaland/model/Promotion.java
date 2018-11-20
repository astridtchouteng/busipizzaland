package be.busi.pizzaland.model;

import javax.persistence.Column;
import java.time.LocalDateTime;

public class Promotion {

    private Long id;
    private LocalDateTime dateDebut;
    private LocalDateTime dateFin;
    private Double montantMinimum;
    private Integer pourcentage;

    public Promotion() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(LocalDateTime dateDebut) {
        this.dateDebut = dateDebut;
    }

    public LocalDateTime getDateFin() {
        return dateFin;
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


