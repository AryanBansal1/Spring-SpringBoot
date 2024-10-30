package demo.practice2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import demo.practice2.model.Users;
import demo.practice2.repo.Myrepo;

@Service
public class RegisterService {
    @Autowired
    Myrepo repos;

    BCryptPasswordEncoder enocoder = new BCryptPasswordEncoder(10);

    public void save (Users user){
        user.setPassword(enocoder.encode(user.getPassword()));
         repos.save(user);
    }
}
