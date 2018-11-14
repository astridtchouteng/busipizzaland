package be.busi.pizzaland.dataAccess.repository;

import be.busi.pizzaland.dataAccess.entity.IngredientEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface IngredientRepository extends JpaRepository<IngredientEntity, Long> {

    public IngredientEntity findByNom(String nom);
}
