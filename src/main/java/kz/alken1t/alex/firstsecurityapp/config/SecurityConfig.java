package kz.alken1t.alex.firstsecurityapp.config;

import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@AllArgsConstructor
public class SecurityConfig  {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.authorizeHttpRequests(authorization -> {
//            authorization.requestMatchers("/admin").hasRole("ADMIN");
            authorization.requestMatchers("/hello","/showUserInfo").hasAnyRole("ADMIN","USER");
            authorization.anyRequest().permitAll();
        });
       httpSecurity.formLogin().loginPage("/auth/login").loginProcessingUrl("/process_login")
               .defaultSuccessUrl("/hello",true)
               .failureUrl("/auth/login?error").and().logout().logoutUrl("/logout").logoutSuccessUrl("/auth/login");
        return httpSecurity.build();
    }
}
