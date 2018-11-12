package be.busi.pizzaland.dataAccess.repository;

import be.busi.pizzaland.dataAccess.entity.CategorieEntity;
import be.busi.pizzaland.model.CategorieEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface CategorieRepository extends JpaRepository<CategorieEntity, Long> {

    CategorieEntity findByCategorieEnum(CategorieEnum categorieEnum);
}
