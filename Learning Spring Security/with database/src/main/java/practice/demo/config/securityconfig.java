package practice.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import practice.demo.service.MyUserDetailService;

import org.springframework.security.core.userdetails.User;;

@Configuration
@EnableWebSecurity
public class securityconfig {


    @Autowired
    MyUserDetailService myUserDetailService;
    
    @Bean
    public SecurityFilterChain chain(HttpSecurity security) throws Exception{

        security.csrf(customizer -> customizer.disable());
        security.authorizeHttpRequests(request -> request.anyRequest().authenticated());
        security.formLogin(Customizer.withDefaults());
        security.httpBasic(Customizer.withDefaults());
        return security.build();
    }

    // @Bean
    // public UserDetailsService userDetailsService(){

    //     UserDetails user1 = User
    //         .withDefaultPasswordEncoder()
    //         .username("ram")
    //         .password("shyaam")
    //         .roles("User")
    //         .build();
            
        

    //     return new InMemoryUserDetailsManager(user1);
    // }

    @Bean
    public AuthenticationProvider authenticationProvider(){
         DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
         provider.setPasswordEncoder(new BCryptPasswordEncoder(10));
         provider.setUserDetailsService(myUserDetailService);
         return provider;
    }


}
