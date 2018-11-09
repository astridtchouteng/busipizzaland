package be.busi.pizzaland.dataAccess.repository;

import be.busi.pizzaland.dataAccess.entity.CategorieEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public interface CategorieRepository extends JpaRepository<CategorieEntity, Long> {
}
