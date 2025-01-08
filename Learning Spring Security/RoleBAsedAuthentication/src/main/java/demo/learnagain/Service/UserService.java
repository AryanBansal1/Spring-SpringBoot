package demo.learnagain.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import demo.learnagain.Entity.Booking;
import demo.learnagain.Entity.MyRegistration;
import demo.learnagain.Repo.BookingRepo;
import demo.learnagain.Repo.Myrepo;

@Service
public class UserService {
    
    @Autowired
    Myrepo repo;

    @Autowired
    BookingRepo bRepo;

    BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(10);
    public void addUSer(MyRegistration reg){
        reg.setPassword(encoder.encode(reg.getPassword()));;
        repo.save(reg);
    }


    public void AddBooking(Booking booking){
        bRepo.save(booking);
    }

    public List<Booking> GetAllBooking(){
        return bRepo.findAll();
    }
}
