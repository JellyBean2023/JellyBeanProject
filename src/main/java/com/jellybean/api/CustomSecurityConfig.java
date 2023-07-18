package com.jellybean.api;

import jakarta.servlet.DispatcherType;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@EnableMethodSecurity
@EnableWebSecurity(debug = true)
@RequiredArgsConstructor
@Configuration
@Log4j2
public class CustomSecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

//        http.formLogin().loginPage("/user/login");

//        http.authorizeHttpRequests().anyRequest().permitAll();
//        http.anonymous().disable();
//        http.exceptionHandling().accessDeniedPage("/user/error");

        http.csrf().disable().cors().disable()
                .authorizeHttpRequests(request -> request
                        .dispatcherTypeMatchers(DispatcherType.FORWARD).permitAll()
                        .requestMatchers("/**").permitAll()
                        .anyRequest().authenticated()
                );/*.formLogin(login -> login
                        .loginPage("/member/login")
                        .loginProcessingUrl("member/login-process")
                        .usernameParameter("useremail")
                        .passwordParameter("userpw")
                        .defaultSuccessUrl("/hello", true)
                        .permitAll()
                ).logout(Customizer.withDefaults());*/

        return http.build();
//        return http.authorizeHttpRequests().anyRequest().permitAll().and().build();
        //http.formLogin().loginPage("/user/login");으로 페이지 지정할 수 있음.
    }


//    @Bean
//    public UserDetailsService userDetailsService() {
//        UserDetails user = User.withDefaultPasswordEncoder()
//                .username("user")
//                .password("password")
//                .roles("USER")
//                .build();
//        return new InMemoryUserDetailsManager(user);
//    }

    @Bean
    public WebSecurityCustomizer webSecurityCustomizer() {
        log.info("------web configure-------");

        return (web) -> web.ignoring().requestMatchers(PathRequest.toStaticResources().atCommonLocations());
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }


}

