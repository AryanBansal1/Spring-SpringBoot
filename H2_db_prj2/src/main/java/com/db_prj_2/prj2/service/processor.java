package com.db_prj_2.prj2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.db_prj_2.prj2.db.Student;
import com.db_prj_2.prj2.repository.Repo;

@Service
public class processor {
    @Autowired
    Repo db;
    public void save(Student ss){
        db.add(ss);
        List<Student> students = db.findall();
        for (Student s : students) {
            System.out.println("Student [rollno=" + s.getrollno() + ", name=" + s.getName() + ", marks=" + s.getMarks() + "]");
        }
        System.out.println("Data saved successfully");


    }
}
