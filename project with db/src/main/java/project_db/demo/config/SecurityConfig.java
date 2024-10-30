package project_db.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import project_db.demo.Service.MyUserDetailService;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Autowired
    MyUserDetailService myUserDetailService;

    @Bean
    public SecurityFilterChain chain(HttpSecurity security)throws Exception{
        security.csrf(customizer -> customizer.disable());
        security.authorizeHttpRequests(request -> request
            .requestMatchers("/register","/register-submit","/register.html").permitAll()
            .anyRequest().authenticated());
        security.formLogin(Customizer.withDefaults());
        security.httpBasic(Customizer.withDefaults());
        return security.build();
    }

    @Bean
    public AuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
        daoAuthenticationProvider.setPasswordEncoder(new BCryptPasswordEncoder(10));
        daoAuthenticationProvider.setUserDetailsService(myUserDetailService);
        return daoAuthenticationProvider;
    }
}
