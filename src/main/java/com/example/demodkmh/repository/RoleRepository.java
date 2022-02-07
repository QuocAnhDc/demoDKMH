package com.example.demodkmh.repository;

import com.example.demodkmh.model.Roles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoleRepository extends JpaRepository<Roles,Long> {

    @Query("Select ur.roles from Users ur where ur.id = ?1")
    List<Roles> getRolesNames(Long userId);

    @Query("SELECT r FROM Roles r WHERE r.name = ?1")
    Roles findRoleByName(String name);
}
