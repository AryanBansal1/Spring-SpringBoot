package learningsecurity.demo.Controller;

import java.util.List;
import java.util.ArrayList;

import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController

public class HomeController {

    @GetMapping("/")
    public String home (HttpServletRequest request){
        return "Weclome home with session id =" + request.getSession().getId();
    }

    List<Student> students = new ArrayList<>(List.of(
        new Student(1,"Aryan","Bansal"),
        new Student(2,"shyam","premi")
    ));

    @GetMapping("/data")
    public List<Student> getdata() {
        
        return students;
        
    }
    @PostMapping("/data")
    public void postData(@RequestBody Student s) {
         students.add(s);
    }
    
    @GetMapping("/csrf-token")
    public CsrfToken getToken(HttpServletRequest request) {
        return (CsrfToken)request.getAttribute("_csrf");
    }
    
    
}
