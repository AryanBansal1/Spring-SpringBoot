package practice.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import practice.demo.Model.Users;
import practice.demo.service.RegisterService;
import jakarta.servlet.http.HttpServletRequest;

@RestController
public class homeController {

    @Autowired
    RegisterService service;

    @GetMapping("/")
    public String home(HttpServletRequest request){
        return "Welcome Home "+ request.getSession().getId();
    }

    @PostMapping("/register")
        public Users register(@RequestBody Users user){
            return service.save(user);
        }
    
}
