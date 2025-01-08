package demo.learnagain.Service;

import java.util.Collection;
import java.util.Collections;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import demo.learnagain.Entity.MyRegistration;

public class UserPrincipal implements UserDetails {

    private MyRegistration reg;

    public UserPrincipal(MyRegistration reg){
        this.reg = reg;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singleton(new SimpleGrantedAuthority(reg.getRole()));
    }

    @Override
    public String getPassword() {
       return reg.getPassword();
    }

    @Override
    public String getUsername() {
        return reg.getUsername();
    }
    
}
