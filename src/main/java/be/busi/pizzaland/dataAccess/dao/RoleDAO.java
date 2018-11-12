package be.busi.pizzaland.dataAccess.dao;

import be.busi.pizzaland.dataAccess.repository.RoleRepository;
import be.busi.pizzaland.dataAccess.util.ProviderConverter;
import be.busi.pizzaland.model.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class RoleDAO {

    @Autowired
    ProviderConverter providerConverter;

    @Autowired
    private RoleRepository roleRepository;

    public List<Role> getAll() {
        System.out.println(roleRepository.findAll().size());
        return roleRepository.findAll().stream()
                .map(p -> providerConverter.roleEntityToRole(p))
                .collect(Collectors.toList());
    }
}

