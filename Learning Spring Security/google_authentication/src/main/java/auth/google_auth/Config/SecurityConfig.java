package auth.google_auth.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity security)throws Exception{
        security.csrf(customizer -> customizer.disable());
        security.authorizeHttpRequests(request -> request.anyRequest().authenticated());
        security.oauth2Login(Customizer.withDefaults());
        security.httpBasic(Customizer.withDefaults());
        return security.build();
    }
}
