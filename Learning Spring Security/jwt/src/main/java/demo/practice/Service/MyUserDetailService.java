package demo.practice.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import demo.practice.Model.UserPrincipal;
import demo.practice.Model.Users;
import demo.practice.Repo.Myrepo;

@Service
public class MyUserDetailService implements UserDetailsService{

    @Autowired
    Myrepo repo;



    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users user = repo.findByUsername(username);

        if(user==null){
            System.out.println("no such user");
            throw new UsernameNotFoundException("no such user");
        }
        return new UserPrincipal(user);
    }

    public void password(Users user){
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(10);
        user.setPassword(encoder.encode(user.getPassword()));
        repo.save(user);
    }


    
}
