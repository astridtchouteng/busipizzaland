package be.busi.pizzaland.dataAccess.util;

import be.busi.pizzaland.dataAccess.entity.CategorieEntity;
import be.busi.pizzaland.dataAccess.entity.PizzaEntity;
import be.busi.pizzaland.dataAccess.entity.RoleEntity;
import be.busi.pizzaland.dataAccess.entity.UserEntity;
import be.busi.pizzaland.model.CategorieEnum;
import be.busi.pizzaland.model.Pizza;
import be.busi.pizzaland.model.Role;
import be.busi.pizzaland.model.RoleEnum;
import be.busi.pizzaland.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
public class ProviderConverter {

    @Autowired
    private PasswordEncoder encodeur;

    public User userEntityToUserModel(UserEntity userEntity) {

        User user = new User();
        user.setUsername(userEntity.getUsername());
        user.setFirstname(userEntity.getFirstname());
        user.setEmail(userEntity.getEmail());
        user.setAdresse(userEntity.getAdresse());
        user.setSexe(userEntity.getSexe());
        user.setPassword(userEntity.getPassword());
        user.setAccountNonExpired(userEntity.isAccountNonExpired());
        user.setAccountNonLocked(userEntity.isAccountNonLocked());
        user.setCredentialsNonExpired(userEntity.isCredentialsNonExpired());
        user.setEnabled(userEntity.isEnabled());

        Set<Role> roles = new HashSet<>();
        userEntity.getAuthorities().stream()
                .forEach(roleEntity -> {
                    roles.add(roleEntityToRole((RoleEntity) roleEntity));
                });
        user.setRoles(roles);

        return user;
    }

    public UserEntity userModelToUserEntity(User user) {
        UserEntity userEntity = new UserEntity();

        userEntity.setUsername(user.getUsername());
        userEntity.setFirstname(user.getFirstname());
        userEntity.setAdresse(user.getAdresse());
        userEntity.setEmail(user.getEmail());
        userEntity.setSexe(user.getSexe());
        userEntity.setPassword(encodeur.encode(user.getPassword()));
        userEntity.setAccountNonExpired(user.isAccountNonExpired());
        userEntity.setAccountNonLocked(user.isAccountNonLocked());
        userEntity.setCredentialsNonExpired(user.isCredentialsNonExpired());
        userEntity.setEnabled(user.isEnabled());

        RoleEntity role = new RoleEntity();
        role.setRole(RoleEnum.ROLE_USER);
        Set<RoleEntity> rolesEntity = new HashSet<>();
        rolesEntity.add(role);
        userEntity.setRoles(rolesEntity);

        return userEntity;
    }

    public Role roleEntityToRole(RoleEntity roleEntity) {
        Role role = new Role();
        role.setNameRole(roleEntity.getRole());
        return role;
    }

    public RoleEntity roleToRoleEntity(Role role) {
        RoleEntity roleEntity = new RoleEntity();
        roleEntity.setRole(role.getNameRole());
        return roleEntity;
    }

    public CategorieEnum categorieEntityToCategorieEnum(CategorieEntity categorieEntity) {

        return categorieEntity.getCategorieEnum();
    }

    public CategorieEntity categorieEnumToCategorie(CategorieEnum categorieEnum){

        CategorieEntity categorieEntity = new CategorieEntity();
        categorieEntity.setCategorieEnum(categorieEnum);
        return categorieEntity;
    }

    public PizzaEntity PizzaModelToPizzaEntity(Pizza pizza) {

        PizzaEntity pizzaEntity = new PizzaEntity();

        pizzaEntity.setCategorie(categorieEnumToCategorie(pizza.getCategorie()));
        pizzaEntity.setPrix(pizza.getPrix());
        pizzaEntity.setDescription(pizza.getDescription());

        return pizzaEntity;
    }

    public Pizza PizzaEntityToPizzaModel(PizzaEntity pizzaEntity) {

        Pizza pizza = new Pizza();

        pizza.setCategorie(categorieEntityToCategorieEnum(pizzaEntity.getCategorie()));
        pizza.setPrix (pizzaEntity.getPrix());
        pizza.setDescription(pizzaEntity.getDescription());

        return pizza;
    }


}
