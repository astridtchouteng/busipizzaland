package be.busi.pizzaland.dataAccess.repository;


import be.busi.pizzaland.dataAccess.entity.IngredientEntity;
import be.busi.pizzaland.dataAccess.entity.PortionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface PortionRepository extends JpaRepository<PortionEntity, Long> {


    List<PortionEntity> findByPrimaryKey_Pizza(Long primaryKey_pizza);
}
