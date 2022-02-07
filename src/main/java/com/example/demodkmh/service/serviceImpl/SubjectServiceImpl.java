package com.example.demodkmh.service.serviceImpl;

import com.example.demodkmh.model.Roles;
import com.example.demodkmh.model.Subjects;
import com.example.demodkmh.repository.SubjectRepository;
import com.example.demodkmh.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class SubjectServiceImpl implements SubjectService {

    @Autowired
    private SubjectRepository subjectRepository;

    public SubjectServiceImpl(SubjectRepository subjectRepository) {
        this.subjectRepository = subjectRepository;
    }

    @Override
    public List<Subjects> getAllSubjects() {
        return subjectRepository.findAll();
    }

    @Override
    public void saveSubject(Subjects subjects) {
        this.subjectRepository.save(subjects);
    }

    @Override
    public Subjects getSubjectById(long id) {
        Optional<Subjects> optional = subjectRepository.findById(id);
        Subjects subjects = null;
        if (optional.isPresent()) {
            subjects = optional.get();
        } else {
            throw new RuntimeException(" Subject not found for id :: " + id);
        }
        return subjects;
    }

    @Override
    public void deleteSubjectById(long id) {
        this.subjectRepository.deleteById(id);
    }

    @Override
    public Page<Subjects> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection) {
        Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending() :
                Sort.by(sortField).descending();

        Pageable pageable = PageRequest.of(pageNo - 1, pageSize, sort);
        return this.subjectRepository.findAll(pageable);
    }

//    @Override
//    public List<Subjects> findAllByUserID(long id) {
//        List<String> subjectsName = new ArrayList<>();
//        subjects= subjectRepository.findAllByUser(id);
//        return subjects;
//    }
    @Override
    public List<Subjects> getAllSubjectRegister(String email) {
        List<Subjects> subjectName = new ArrayList<>();
        List<Subjects> subjects = subjectRepository.findAllByUser(email);
        for(Subjects subject : subjects) {
            subjectName.add(subject);
        }
        return  subjectName;
    }
}
