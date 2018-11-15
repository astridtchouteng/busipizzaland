package be.busi.pizzaland.dataAccess.repository;

import be.busi.pizzaland.dataAccess.entity.PromotionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface PromotionRepository extends JpaRepository<PromotionEntity, Long> {
}
