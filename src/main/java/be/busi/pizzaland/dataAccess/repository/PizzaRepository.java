package be.busi.pizzaland.dataAccess.repository;

import be.busi.pizzaland.dataAccess.entity.CategorieEntity;
import be.busi.pizzaland.dataAccess.entity.PizzaEntity;
import be.busi.pizzaland.model.Categorie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface PizzaRepository extends JpaRepository<PizzaEntity, Long> {


    List<PizzaEntity> findByCategorie(CategorieEntity categorie);

    PizzaEntity findByNom(String nom);
}
