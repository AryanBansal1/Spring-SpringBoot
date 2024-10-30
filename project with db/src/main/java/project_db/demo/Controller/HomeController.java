package project_db.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.PostMapping;
import project_db.demo.Model.Users;
import project_db.demo.Service.MyUserDetailService;



@RestController
public class HomeController {

    @Autowired
    MyUserDetailService myUserDetailService;
    
    @GetMapping("/")
    public String home(HttpServletRequest request){
        return "Welcome to home "+ request.getSession().getId();
    }
    @GetMapping("/loging")
    public RedirectView login() {

        return new RedirectView("login.html");
    }

    @PostMapping("/register-submit")
    public Users registeration(@ModelAttribute Users user) {
        return myUserDetailService.register(user);
    }

    @GetMapping("/register")
    public RedirectView register(){
        return new RedirectView("register.html");
    }
    
    
}
