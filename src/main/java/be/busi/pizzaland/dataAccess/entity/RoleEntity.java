package be.busi.pizzaland.dataAccess.entity;

import be.busi.pizzaland.model.RoleEnum;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "role")
public class RoleEntity implements GrantedAuthority {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "role", unique = true, length = 50)
    @NotNull
    @Enumerated(value = EnumType.STRING)
    private RoleEnum role;

    @ManyToMany(mappedBy = "role")
    private Set<UserEntity> users = new HashSet<>();

    public RoleEntity() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public void addUser(UserEntity userEntity){
        users.add(userEntity);
    }

    @Override
    public String getAuthority() {
        return role.name();
    }
}
