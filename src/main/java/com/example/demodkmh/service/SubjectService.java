package com.example.demodkmh.service;

import com.example.demodkmh.model.Subjects;
import org.springframework.data.domain.Page;

import java.util.List;

public interface SubjectService {
    List<Subjects> getAllSubjects();
    void saveSubject(Subjects subjects);
    Subjects getSubjectById(long id);
    void deleteSubjectById(long id);
    Page<Subjects> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection);
    List<Subjects> getAllSubjectRegister(String email);
//    List<Subjects> findAllByUserID(long id);
}
