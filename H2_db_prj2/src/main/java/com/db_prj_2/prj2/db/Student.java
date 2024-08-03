package com.db_prj_2.prj2.db;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class Student {
    private int rollno;
    private String name;
    private int marks;

    public int getrollno(){
        return this.rollno;
    }
    public void setrollno(int rollno){
        this.rollno = rollno;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getMarks() {
        return marks;
    }
    public void setMarks(int marks) {
        this.marks = marks;
    }
}
