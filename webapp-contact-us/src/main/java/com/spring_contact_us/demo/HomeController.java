package com.spring_contact_us.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring_contact_us.demo.repo.Hrepository;

@Controller
public class HomeController {
    @Autowired
    Hrepository repo;
    @RequestMapping("/")
    public String contactus(){
        System.out.println("reached index file");
        return "index.jsp";
    }

    @PostMapping("/submit")
    public String submit(@ModelAttribute Info infobjc){
        System.out.println("entered this process");
        System.out.println(infobjc.getFname());
        System.out.println(infobjc.getMail());
        System.out.println(infobjc.getLtext());
        repo.db_execution(infobjc);

        return "submit.jsp";
    }
}
