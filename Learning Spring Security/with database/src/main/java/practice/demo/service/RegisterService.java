package practice.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import practice.demo.Model.Users;
import practice.demo.repo.Myrepo;

@Service
public class RegisterService {
    
    @Autowired
    Myrepo rep;

    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(10);

    public Users save(Users user){
        user.setPassword(encoder.encode(user.getPassword()));
        return rep.save(user);
    }
}
