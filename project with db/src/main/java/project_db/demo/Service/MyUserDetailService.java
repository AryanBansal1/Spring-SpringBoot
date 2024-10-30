package project_db.demo.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import project_db.demo.Model.MyUserPrincipal;
import project_db.demo.Model.Users;
import project_db.demo.repo.Myrepo;

@Service
public class MyUserDetailService implements UserDetailsService{

    @Autowired
    Myrepo repo;

    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(10);

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Users user = repo.findByUsername(username);
        if(user==null){
            System.out.println("No user found");
            throw new UsernameNotFoundException("No user found");
        }
         return new MyUserPrincipal(user);
    }

    public Users register(Users user){
        user.setPassword(encoder.encode(user.getPassword()));
        return repo.save(user);
    }
    
}
