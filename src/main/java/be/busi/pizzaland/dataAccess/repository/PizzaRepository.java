package be.busi.pizzaland.dataAccess.repository;

import be.busi.pizzaland.dataAccess.entity.PizzaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public interface PizzaRepository extends JpaRepository<PizzaEntity, Long> {
}
