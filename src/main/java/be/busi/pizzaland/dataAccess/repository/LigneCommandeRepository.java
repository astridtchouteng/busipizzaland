package be.busi.pizzaland.dataAccess.repository;

import be.busi.pizzaland.dataAccess.entity.LigneCommandeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface LigneCommandeRepository extends JpaRepository<LigneCommandeEntity, Long> {
}
