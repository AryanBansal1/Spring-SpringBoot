package auth.google_auth.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class HomeController {
    

    @GetMapping("/")
    public String home(@RequestParam String param) {
        return "Welcome home";
    }
    
}
