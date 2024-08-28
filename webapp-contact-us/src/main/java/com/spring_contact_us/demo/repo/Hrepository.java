package com.spring_contact_us.demo.repo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.spring_contact_us.demo.Info;

@Repository
public class Hrepository {
    @Autowired
    JdbcTemplate db;
    public void db_execution(Info infobjc){
    String query = "Insert into Contact value (?,?,?)";
    int rowaffected = db.update(query,infobjc.getFname(),infobjc.getMail(),infobjc.getLtext());
    System.out.println(rowaffected);
    }
}
