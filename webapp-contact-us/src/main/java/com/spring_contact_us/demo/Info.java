package com.spring_contact_us.demo;

import org.springframework.stereotype.Component;

@Component
public class Info {
    private String fname;
    private String mail;
    private String ltext;
    public String getFname() {
        return fname;
    }
    public void setFname(String fname) {
        this.fname = fname;
    }
    public String getMail() {
        return mail;
    }
    public void setMail(String mail) {
        this.mail = mail;
    }
    public String getLtext() {
        return ltext;
    }
    public void setLtext(String ltext) {
        this.ltext = ltext;
    }
    
}
