package demo.practice2.config;

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

import demo.practice2.service.MyUserDetailService;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Autowired
    MyUserDetailService myUserDetailService;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity security) throws Exception{
        security.csrf(Customizer -> Customizer.disable());
        security.authorizeHttpRequests(request -> request
            .requestMatchers("/html/login.html","/html/register.html","/register-process").permitAll()
            .anyRequest().authenticated());
        security.formLogin(form -> form
            .loginPage("/html/login.html")
            .loginProcessingUrl("/perform_login")
            .defaultSuccessUrl("/",true)
            .failureUrl("/html/404.html")
        );
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
