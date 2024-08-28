package com.SpringWEBAPP.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class HomeController {
    @RequestMapping("/")
    public String home(){
        return "index.jsp";
    }
    @RequestMapping("add")
    public String add(@RequestParam("num1") int n1, @RequestParam("num2") int n2, Model model){
        System.out.println("reached add method");
        int result = n1*n2;
        model.addAttribute("res", result);
        return "result.jsp";
    }
}
