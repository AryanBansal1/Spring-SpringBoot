package demo.practice2.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import demo.practice2.model.Users;
import demo.practice2.service.RegisterService;


@Controller
public class HomeController {

    @Autowired
    RegisterService register;

        @GetMapping("/")
        public String home(){
            return "/html/home.html";
        }

        @PostMapping("/register-process")
        public String register(@ModelAttribute Users user) {
            register.save(user);
            return "redirect:/html/login.html";
        }
        
}
