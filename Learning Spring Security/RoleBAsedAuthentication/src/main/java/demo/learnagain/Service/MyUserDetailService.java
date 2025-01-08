package demo.learnagain.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import demo.learnagain.Entity.MyRegistration;
import demo.learnagain.Repo.Myrepo;

@Service
public class MyUserDetailService implements UserDetailsService{

    @Autowired
    Myrepo repo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        MyRegistration user = repo.findByUsername(username);

        if (user==null){
            System.out.println("User not found");
            throw new UsernameNotFoundException("user not found");
        }
        return new UserPrincipal(user);
    }
    
}
