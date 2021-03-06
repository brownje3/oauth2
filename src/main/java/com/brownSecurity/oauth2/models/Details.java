package com.brownSecurity.oauth2.models;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Details implements UserDetails {
    private final MyUser myUser;

    public Details(MyUser myUser){
        this.myUser = myUser;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<Role> roles = myUser.getRoles();
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();

        for (Role role : roles) {
            authorities.add(new SimpleGrantedAuthority(role.getName()));
        }
        return authorities;
    }

    @Override
    public String getPassword() {
        return myUser.getPassword();
    }

    @Override
    public String getUsername() {
        return myUser.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return myUser.isActive();
    }

    @Override
    public boolean isAccountNonLocked() {
        return myUser.isActive();
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return myUser.isActive();
    }

    @Override
    public boolean isEnabled() {
        return myUser.isActive();
    }
}

