package com.example.demodkmh.service.serviceImpl;

import com.example.demodkmh.model.Roles;
import com.example.demodkmh.repository.RoleRepository;
import com.example.demodkmh.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public List<String> getRoleNames(Long userId) {
        List<String> roleName = new ArrayList<>();
        List<Roles> roles = roleRepository.getRolesNames(userId);
        for(Roles role : roles) {
            roleName.add(role.getName());
        }
        return  roleName;
    }
}
