package be.busi.pizzaland.model;

import org.springframework.security.core.GrantedAuthority;

import java.util.HashSet;
import java.util.Set;

public class Role implements GrantedAuthority {

    private RoleEnum nameRole;
    private Set<User> users = new HashSet<>();

    public Role() {
    }

    public RoleEnum getNameRole() {
        return nameRole;
    }

    public void setNameRole(RoleEnum nameRole) {
        this.nameRole = nameRole;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    public void addUser(User user) {
        users.add(user);
    }

    public void addUsers(Set<User> users) {
        this.users = users;
    }

    @Override
    public String getAuthority() {
        return nameRole.name();
    }
}

