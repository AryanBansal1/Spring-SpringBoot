package demo.learn;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletRequest;

@RestController
public class HomeController {

        @GetMapping("/")
        public String home(HttpServletRequest request){
            return "Welcome home "+request.getSession().getId() ;
        }
}
