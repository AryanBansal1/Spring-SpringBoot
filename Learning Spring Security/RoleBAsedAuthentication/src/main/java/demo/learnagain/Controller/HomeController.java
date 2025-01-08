package demo.learnagain.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import demo.learnagain.Entity.Booking;
import demo.learnagain.Entity.MyRegistration;
import demo.learnagain.Service.UserService;
import org.springframework.web.bind.annotation.RequestBody;





@Controller
public class HomeController {

        @Autowired
        UserService ser;
        @GetMapping("/")
        public String Home() {
            return "/html/home.html";
        }
        @PostMapping("/register_process")
        public String register(@ModelAttribute MyRegistration myRegistration) {
            ser.addUSer(myRegistration);
            return "/html/login.html";
        }

        @PostMapping("/confirmbook")
        public String BookingDone(@ModelAttribute Booking booking) {
            System.out.println("Reached here");
            ser.AddBooking(booking);
            return "redirect:/html/home.html";
        }
        
        
        
}
