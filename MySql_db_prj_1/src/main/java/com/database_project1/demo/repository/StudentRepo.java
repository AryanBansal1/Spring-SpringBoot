package com.database_project1.demo.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.database_project1.demo.jdbc.Student;
@Repository
public class StudentRepo {
    @Autowired
    JdbcTemplate jdbc;
    public void save(Student st){
        
        String query = "insert into Student(rollno , name, marks) values (?,?,?)";
        int rowaffected = jdbc.update(query,st.getrollno(),st.getName(),st.getMarks());
        System.out.println("rows affected " + rowaffected);
        System.out.println("data saved to database");

    }
}
