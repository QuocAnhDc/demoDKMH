package com.example.demodkmh.service;

import com.example.demodkmh.dto.UserRegistrationDto;
import com.example.demodkmh.model.Users;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService {
    Users save(UserRegistrationDto registrationDto);

    Users registerSubject(Long id,String email);

    Users removeSubject(String email,Long idSub);
}
