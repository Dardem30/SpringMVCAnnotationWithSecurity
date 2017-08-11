package by.service;

import by.model.RoleEntity;
import by.model.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by УВД on 11.08.2017.
 */
@Service
public class UserDetailServiceImpl implements UserDetailsService {
    @Autowired
    private UserService userService;
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        UserEntity userEntity=userService.getUserByUsername(s);
        Set<GrantedAuthority> grantedAuthoritySet=new HashSet<GrantedAuthority>();
        for(RoleEntity roleEntity: userEntity.getRoleEntitySet()){
            grantedAuthoritySet.add(new SimpleGrantedAuthority(roleEntity.getName()));
        }
        return new User(userEntity.getUsername(),userEntity.getPassword(),grantedAuthoritySet);
    }
}
