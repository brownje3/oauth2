package com.brownSecurity.oauth2.services;

import com.brownSecurity.oauth2.DTOs.RegistrationDTO;
import com.brownSecurity.oauth2.models.MyUser;
import com.brownSecurity.oauth2.models.MyUserDetails;
import com.brownSecurity.oauth2.models.Privilege;
import com.brownSecurity.oauth2.models.Role;
import com.brownSecurity.oauth2.repository.RoleRepo;
import com.brownSecurity.oauth2.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Collections;

@Service
@Transactional
public class UserService implements UserDetailsService {
    private final ApplicationContext context;
    private final UserRepo userRepo;
    private final RoleRepo roleRepo;

    @Autowired
    public UserService(UserRepo userRepo, RoleRepo roleRepo, ApplicationContext context) {
        this.userRepo = userRepo;
        this.roleRepo = roleRepo;
        this.context = context;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        try {
            MyUser myUser = userRepo.findByUsername(username);

            return new MyUserDetails(myUser);
        } catch (Exception e) {
            throw new UsernameNotFoundException(String.format("MyUser with username: %s not found", username));
        }
    }

    public MyUser registerUser(RegistrationDTO registrationDTO){
        MyUser myUser = new MyUser(registrationDTO, context.getBean(PasswordEncoder.class));

        myUser.setRoles(Collections.singletonList(roleRepo.findByName("ROLE_USER")));

        return userRepo.save(myUser);
    }

    private ArrayList<? extends GrantedAuthority> getAuthorities(ArrayList<Role> roles) {
        return getGrantedAuthorities(getPrivileges(roles));
    }

    private ArrayList<String> getPrivileges(ArrayList<Role> roles) {
        ArrayList<String> privileges = new ArrayList<>();
        ArrayList<Privilege> collection = new ArrayList<>();

        for (Role role : roles) {
            privileges.add(role.getName());
            collection.addAll(role.getPrivileges());
        }

        for (Privilege item : collection) {
            privileges.add(item.getName());
        }

        return privileges;
    }

    private ArrayList<GrantedAuthority> getGrantedAuthorities(ArrayList<String> privileges) {
        ArrayList<GrantedAuthority> authorities = new ArrayList<>();

        for (String privilege : privileges) {
            authorities.add(new SimpleGrantedAuthority(privilege));
        }

        return authorities;
    }
}
