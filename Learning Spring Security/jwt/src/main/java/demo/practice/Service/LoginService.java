package demo.practice.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import demo.practice.Model.Users;

@Service
public class LoginService {

        @Autowired
        AuthenticationManager manager;

        @Autowired
        private JWTService jwtService;

        public String verify(Users user) {
        Authentication authentication = manager.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));

        if(authentication.isAuthenticated()){
            return jwtService.GenerateToken(user.getUsername());
        }
        else{
            return "failed";
        }
    }
}
