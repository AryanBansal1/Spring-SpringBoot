package demo.learnagain.Config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import demo.learnagain.Service.MyUserDetailService;

@Configuration
@EnableWebSecurity
public class MyConfig {

    @Autowired
    public MyUserDetailService userDetailService;
    
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity security, CustomAuthenticationSuccessHandler successHandler ) throws Exception{
        return security
            .csrf(Customizer -> Customizer.disable())
            .authorizeHttpRequests(request -> request
                                .requestMatchers("html/login.html","/css/**","/Images/**","/html/404.html","html/register.html","/register_process")
                                .permitAll() 
                                .requestMatchers("/Admin/**").hasRole("Admin")           
                                .anyRequest().authenticated())
            .formLogin(form -> form
                                .loginPage("/html/login.html")
                                .loginProcessingUrl("/perform_login")
                                .successHandler(successHandler)
                                .failureUrl("/html/404.html?error=true"))
            .httpBasic(Customizer -> Customizer.disable())
            .build();
    }

    @Bean
    public AuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
        daoAuthenticationProvider.setUserDetailsService(userDetailService);
        daoAuthenticationProvider.setPasswordEncoder(new BCryptPasswordEncoder(10));
        return daoAuthenticationProvider;
    }

}
