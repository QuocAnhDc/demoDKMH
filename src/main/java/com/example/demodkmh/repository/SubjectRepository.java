package com.example.demodkmh.repository;

import com.example.demodkmh.model.Roles;
import com.example.demodkmh.model.Subjects;
import com.example.demodkmh.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SubjectRepository extends JpaRepository<Subjects,Long> {
    @Query("SELECT s FROM Subjects s WHERE s.id = ?1")
    Subjects findSubjectById(Long id);

    @Query("Select ur.subjects from Users ur where ur.email = ?1")
    List<Subjects> findAllByUser(String email);

//    @Query("select s from Subjects s inner join dkmh s1 on s.id = s1.subject_id where s1.user_id =?1")
//    List<Subjects> findByUser(Long userId);
}
