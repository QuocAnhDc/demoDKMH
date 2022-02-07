package com.example.demodkmh.config;

import com.example.demodkmh.model.Roles;
import com.example.demodkmh.model.Users;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

public class MyUserDetails implements UserDetails {

    private Users users;

    public MyUserDetails(Users users) {
        this.users = users;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Set<Roles> roles =users.getRoles();

        List<SimpleGrantedAuthority> authories = new ArrayList<>();
        for(Roles role : roles) {
            authories.add(new SimpleGrantedAuthority(role.getName()));
        }

        return authories;
    }

    @Override
    public String getPassword() {
        return users.getPassword();
    }

    @Override
    public String getUsername() {
        return users.getEmail();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return users.isEnabled();
    }
    public String getFirstname(){
        return users.getFirstName();
    }
}
