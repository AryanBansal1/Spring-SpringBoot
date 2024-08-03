package com.database_project1.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.database_project1.demo.jdbc.Student;
import com.database_project1.demo.repository.StudentRepo;

@Service
public class StudentService {
    @Autowired
    StudentRepo repo;
    public void addrow(Student s){
        System.out.println("Added");
        repo.save(s);
    }


}
