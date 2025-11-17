package com.etsesports.etsesports.school;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/schools")
public class SchoolController {
    private final SchoolService schoolService;

    @Autowired
    public SchoolController(SchoolService schoolService) {
        this.schoolService = schoolService;
    }

    @GetMapping
    public List<School> getSchools() {
        return schoolService.getSchools();
    }

    @PostMapping
    public void createSchool(@RequestBody School school) {
        schoolService.createSchool(school);
    }

    @DeleteMapping(path = "{schoolId}")
    public void deleteSchool(@PathVariable("schoolId") Long schoolId) {
        schoolService.deleteSchool(schoolId);
    }

    @PutMapping(path = "{schoolId}")
    public void updateSchool(@PathVariable("schoolId") Long schoolId, @RequestParam(required = false) String name) {
        schoolService.updateSchool(schoolId, name);
    }
}
