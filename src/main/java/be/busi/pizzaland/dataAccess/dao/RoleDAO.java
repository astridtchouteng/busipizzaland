package be.busi.pizzaland.dataAccess.dao;


import be.busi.pizzaland.dataAccess.entity.RoleEntity;
import be.busi.pizzaland.dataAccess.repository.RoleRepository;
import be.busi.pizzaland.dataAccess.util.ProviderConverter;
import be.busi.pizzaland.model.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class RoleDAO {

    @Autowired
    private ProviderConverter providerConverter;

    @Autowired
    private RoleRepository roleRepository;

    public List<Role> getAll() {

        List<RoleEntity> roleEntities = roleRepository.findAll();

        List<Role> roles = new ArrayList<>();
        for (RoleEntity  role : roleEntities)
        {
            roles.add(providerConverter.roleEntityToRole(role));
        }

        return roles;
    }
}
