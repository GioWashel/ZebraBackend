package com.zebra.service;
import com.zebra.repository.TokenRepository;
import com.zebra.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;




@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private final UserRepository repository;
    private final TokenRepository tokenRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    public boolean register() {
        return false;
    }
    public boolean authenticate() {
        return true;
    }
}


