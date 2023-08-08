package com.zebra.service;

import com.zebra.entity.User;
import com.zebra.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.Optional;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    UserRepository repository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = repository.findByEmail(username);
        if(user.equals(Optional.empty())) {
            throw new UsernameNotFoundException("Email not found");
        }
        return user.get();
    }
}
