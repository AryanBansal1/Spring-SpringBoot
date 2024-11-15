package demo.practice.Config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import demo.practice.Service.MyUserDetailService;

@Configuration
@EnableWebSecurity
public class Myconfig {

    @Autowired
    MyUserDetailService myUserDetailService;

    @Autowired
    JwtFilter jwtFilter;
    
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity security)throws Exception{
        security.csrf(Customizer-> Customizer.disable());
        security.authorizeHttpRequests(request -> request
            .requestMatchers("/css/*","/Images/*","/html/login.html","/html/register.html","/html/404.html","/register_process","/perform_login").permitAll()
            .anyRequest().authenticated()
            );
        // security.formLogin(form -> form
        //     .defaultSuccessUrl("/",true)
        //     .loginPage("/html/login.html")
        //     .loginProcessingUrl("/perform_login")
        //     .failureUrl("/html/404.html"));
        security.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
        security.httpBasic(Customizer.withDefaults());
        security.addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);
        return security.build();
    }

    @Bean 
    public AuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setUserDetailsService(myUserDetailService);
        provider.setPasswordEncoder(new BCryptPasswordEncoder(10));
        return provider;
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception{
        return config.getAuthenticationManager();
    }
}
