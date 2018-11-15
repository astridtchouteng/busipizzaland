package be.busi.pizzaland.dataAccess.repository;

import be.busi.pizzaland.dataAccess.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface UserRepository extends JpaRepository<UserEntity, Long> {

    UserEntity findByUsername(String userName);

    UserEntity getByUsername(String username);

    boolean findUserEntitiesByFirstname(String username);
}
