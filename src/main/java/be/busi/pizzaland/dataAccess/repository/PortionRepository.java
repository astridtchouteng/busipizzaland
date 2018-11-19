package be.busi.pizzaland.dataAccess.repository;


import be.busi.pizzaland.dataAccess.entity.IngredientEntity;
import be.busi.pizzaland.dataAccess.entity.PortionEntity;
import be.busi.pizzaland.model.Portion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface PortionRepository extends JpaRepository<PortionEntity, Long> {

    //@Query("select p from PortionEntity p where p.pizza_id = ?1")
    List<PortionEntity> findByPrimaryKey_Pizza(Long idPizza);
}
