package ru.webproject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import ru.webproject.Domain.Authority;
import ru.webproject.Domain.User;
import ru.webproject.Repository.UserRepository;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class MyUserPrincipial implements UserDetails {


    private User user;

    private Collection<? extends GrantedAuthority> authorities;

    public MyUserPrincipial(User user) {
        this.user = user;
    }

    public MyUserPrincipial(User user, List<Authority> authorities) {
        this.user = user;
        this.authorities = authorities.stream().map(c -> new SimpleGrantedAuthority(c.getAuthority())).collect(Collectors.toList());
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getUsername();
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
        return user.isEnabled();
    }
}
