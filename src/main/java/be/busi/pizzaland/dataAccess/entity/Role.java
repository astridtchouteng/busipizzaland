package be.busi.pizzaland.dataAccess.entity;

import be.busi.pizzaland.model.RoleEnum;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.util.HashSet;
import java.util.Set;

public class Role implements GrantedAuthority {

    @Enumerated(value = EnumType.STRING)
    @Column(name = "role")
    private RoleEnum role;

    private Set<UserEntity> users = new HashSet<>();

    public Role() {}

    public RoleEnum getRole() {
        return role;
    }

    public void setRole(RoleEnum role) {
        this.role = role;
    }

    public Set<UserEntity> getUsers() {
        return users;
    }

    public void setUsers(Set<UserEntity> users) {
        this.users = users;
    }

    @Override
    public String getAuthority() {
        return role.getRole();
    }
}
