package com.example.demodkmh.repository;

import com.example.demodkmh.model.Roles;
import com.example.demodkmh.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<Users,Long> {

    @Query("SELECT u FROM Users u WHERE u.email = ?1")
    Users findUsersByEmail(String email);

    @Query("SELECT u FROM Users u WHERE u.email = :email")
    public Users getUserByEmail(@Param("email") String email);
}
