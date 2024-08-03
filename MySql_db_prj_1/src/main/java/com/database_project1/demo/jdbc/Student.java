package com.database_project1.demo.jdbc;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class Student {
    private int rollNo;
    private String Name;
    private int Marks;

    public int getrollno (){
        return this.rollNo;
    }
    public void setrollno (int rollNo){
        this.rollNo = rollNo;
    }
    public String getName() {
        return Name;
    }
    public void setName(String name) {
        Name = name;
    }
    public int getMarks() {
        return Marks;
    }
    public void setMarks(int marks) {
        Marks = marks;
    }

}
