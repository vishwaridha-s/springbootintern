package com.example.employeespringboot.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableMethodSecurity
public class SpringConfiguration {

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf((csrf)->csrf.disable())
//                .authorizeHttpRequests(auth-> {
////                    auth.requestMatchers(HttpMethod.POST,"/e").hasRole("ADMIN");
////                    auth.requestMatchers(HttpMethod.PUT,"/e").hasRole("ADMIN");
////                    auth.requestMatchers(HttpMethod.DELETE,"/e").hasRole("ADMIN");
////                    auth.requestMatchers(HttpMethod.GET,"/**").hasAnyRole("ADMIN","USER");
////                    auth.anyRequest().authenticated();})
                        .httpBasic(Customizer.withDefaults());
        return http.build();
    }
    @Bean
//    InMemoryUserDetailsManager
    UserDetailsService userDetails(){
        UserDetails admin = User.builder()
                .username("admin")
                .password(passwordEncoder().encode("admin"))
                .roles("ADMIN")
                .build();
        UserDetails varsh = User.builder()
                .username("varsh")
                .password(passwordEncoder().encode("varsh"))
                .roles("USER")
                .build();
        return new InMemoryUserDetailsManager(admin,varsh);
    }
}