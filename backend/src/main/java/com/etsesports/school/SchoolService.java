package com.etsesports.etsesports.school;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SchoolService {
    private final SchoolRepository schoolRepository;

    @Autowired
    public SchoolService(SchoolRepository schoolRepository){
        this.schoolRepository = schoolRepository;
    }

    public List<School> getSchools() {
        return schoolRepository.findAll();
    }

    public void createSchool(School school) {
        schoolRepository.save(school);
    }

    public void deleteSchool(Long schoolId) {
        schoolRepository.deleteById(schoolId);
    }

    @Transactional
    public void updateSchool(Long schoolId, String name){
        School school = schoolRepository.findById(schoolId).orElseThrow(() -> new IllegalStateException("School with id " + schoolId + " does not exist"));
        school.setName(name);
    }
}
