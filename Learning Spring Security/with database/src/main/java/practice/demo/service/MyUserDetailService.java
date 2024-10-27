package practice.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import practice.demo.Model.MyUserPrincipal;
import practice.demo.Model.Users;
import practice.demo.repo.Myrepo;

@Service
public class MyUserDetailService implements UserDetailsService{

    @Autowired
    Myrepo repoObj;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Users user = repoObj.findByUsername(username);
        
        if(user==null){
            System.out.println("User not found");
            throw new UsernameNotFoundException("User not found");
        }

        return new MyUserPrincipal(user);
    }
}
