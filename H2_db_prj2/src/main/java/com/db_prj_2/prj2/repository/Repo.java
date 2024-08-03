package com.db_prj_2.prj2.repository;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.db_prj_2.prj2.db.Student;

@Repository
public class Repo {
    @Autowired
    JdbcTemplate db;

    public void add(Student s){

        // Insert Query 
        String query = "Insert into Student(rollno,name,marks) values (?,?,?)";
        int rowaffected = db.update(query,s.getrollno(),s.getName(),s.getMarks());
        System.out.println("data inserted and row affected = "+ rowaffected);
    }

    public List<Student> findall(){
        // SELECT QUERY
        String query2 = "Select * from Student";

        RowMapper<Student> mapper = new RowMapper<Student>() {
            @Override
            public Student mapRow(ResultSet rs,int rowNum) throws SQLException{
                Student s = new Student();
                s.setrollno(rs.getInt("rollno"));
                s.setName(rs.getString("name"));
                s.setMarks(rs.getInt("marks"));
                return s;
            }
        };

        return db.query(query2, mapper);
    }

}

