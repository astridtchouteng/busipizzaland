package be.busi.pizzaland.dataAccess.dao;

import be.busi.pizzaland.dataAccess.entity.UserEntity;
import be.busi.pizzaland.dataAccess.repository.UserRepository;
import be.busi.pizzaland.dataAccess.Util.ProviderConverter;
import be.busi.pizzaland.exception.UserExistsException;
import be.busi.pizzaland.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class UserDAO implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ProviderConverter providerConverter;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserDetails user = userRepository.findByUsername(username);

        if(user == null)
            throw new UsernameNotFoundException("User not Found");
        return user;
    }

    public User save(User user) throws UserExistsException {

        user.setAccountNonLocked(true);
        user.setCredentialsNonExpired(true);
        user.setAccountNonExpired(true);
        user.setEnabled(true);
        UserEntity userEntity = providerConverter.userModelToUserEntity(user);
        userEntity = userRepository.save(userEntity);
        System.out.println(userEntity.getId());
        return providerConverter.userEntityToUserModel(userEntity);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        BCryptPasswordEncoder encodeur = new BCryptPasswordEncoder();
        return encodeur;
    }

    public boolean existUser(String username){
        return userRepository.findUserEntitiesByFirstname(username);
    }


}
