package demo.practice.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import demo.practice.Model.Users;
import demo.practice.Service.LoginService;
import demo.practice.Service.MyUserDetailService;


@Controller
public class HomeController {

    @Autowired
    MyUserDetailService service;

    @Autowired
    LoginService loginService;
    
    @GetMapping("/")
    public String home(){
        return "/html/login.html";
    }

    @PostMapping("/register_process")
    public String register(@ModelAttribute Users user) {
        System.out.println(user);
        service.password(user);
        return "redirect:/html/login.html";
    }

    @PostMapping("/perform_login")
    public String login(@ModelAttribute Users user){
        System.out.println("user is trying to login");
        System.out.println(loginService.verify(user));
        return "redirect:/html/home.html";
    }
    
}
