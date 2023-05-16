package com.eduardo.backendproject.services;

import java.nio.CharBuffer;

import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.eduardo.backendproject.controllers.dto.CredentialsDto;
import com.eduardo.backendproject.controllers.dto.UserDto;

@Service
public class AuthenticationService {
	
	private final PasswordEncoder passwordEncoder;
	
    public AuthenticationService(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    public UserDto authenticate(CredentialsDto credentialsDto) {
        String encodedMasterPassword = passwordEncoder.encode(CharBuffer.wrap("the-password"));
        if (passwordEncoder.matches(CharBuffer.wrap(credentialsDto.getPassword()), encodedMasterPassword)) {
            return new UserDto(1L, "Eduardo", "Tribeno", "login", "token");
        }
        throw new RuntimeException("Invalid password");
    }

    public UserDto findByLogin(String login) {
        if ("login".equals(login)) {
            return new UserDto(1L, "Eduardo", "Tribeno", "login", "token");
        }
        throw new RuntimeException("Invalid login");
    }
}
