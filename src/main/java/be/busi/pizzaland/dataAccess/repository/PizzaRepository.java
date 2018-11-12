package be.busi.pizzaland.dataAccess.repository;

import be.busi.pizzaland.dataAccess.entity.CategorieEntity;
import be.busi.pizzaland.dataAccess.entity.PizzaEntity;
import be.busi.pizzaland.model.CategorieEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public interface PizzaRepository extends JpaRepository<PizzaEntity, Long> {

    List<PizzaEntity> findByCategorieCategorieEnum(CategorieEnum categorie_categorieEnum);

    //PizzaEntity findByNom(String nom);
}
