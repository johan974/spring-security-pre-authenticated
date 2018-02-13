package com.oreilly.security.web.controllers;

import org.springframework.dao.DataAccessException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.core.userdetails.User;

import java.util.ArrayList;
import java.util.List;

public class CustomUserDetailsService implements UserDetailsService
{
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException, DataAccessException
    {
        System.out.println("username recieved :: " + username);
        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add( new SimpleGrantedAuthority("ROLE_USER"));
        UserDetails user = new User(username, "password", true, true, true, true, authorities);
        return user;
    }
}

