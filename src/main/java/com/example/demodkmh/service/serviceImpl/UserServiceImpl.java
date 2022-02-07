package com.example.demodkmh.service.serviceImpl;

import com.example.demodkmh.dto.UserRegistrationDto;
import com.example.demodkmh.model.Users;
import com.example.demodkmh.repository.RoleRepository;
import com.example.demodkmh.repository.SubjectRepository;
import com.example.demodkmh.repository.UserRepository;
import com.example.demodkmh.service.UserService;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private SubjectRepository subjectRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;


    @Override
    public Users save(UserRegistrationDto registrationDto) {
        Users users = new Users();
        users.setFirstName(registrationDto.getFirstName());
        users.setLastName(registrationDto.getLastName());
        users.setEmail(registrationDto.getEmail());
        users.setPassword(passwordEncoder.encode(registrationDto.getPassword()));
        users.setEnabled(true);
        users.addRole(roleRepository.findRoleByName("ROLE_USER"));
        Users save = userRepository.save(users);
        return save;
    }

    @Override
    public Users registerSubject(Long id,String email) {
        Users users = userRepository.findUsersByEmail(email);
        users.addSubject(subjectRepository.findSubjectById(id));
        Users save = userRepository.save(users);
        return save;
    }

    @Override
    public Users removeSubject(String email, Long idSub) {
        Users users = userRepository.findUsersByEmail(email);
        users.deleteSubject(subjectRepository.findSubjectById(idSub));
        Users save = userRepository.save(users);
        return save;
    }
}
