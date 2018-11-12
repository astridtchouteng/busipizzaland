package be.busi.pizzaland.dataAccess.repository;

import be.busi.pizzaland.dataAccess.entity.RoleEntity;
import be.busi.pizzaland.model.RoleEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface RoleRepository extends JpaRepository<RoleEntity, Long> {

    //public RoleEntity findByAuthorityOrRole(RoleEnum role);
}
