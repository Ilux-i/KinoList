//package org.example.configuration;
//
//import org.example.filter.FilterUserController;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.http.SessionCreationPolicy;
//import org.springframework.security.web.SecurityFilterChain;
//import org.springframework.security.web.authentication.*;
//
//@Configuration
//public class SecurityConfig {
//        @Bean
//        SecurityFilterChain filterChain(
//            HttpSecurity http
//    ) throws Exception {
//        http.sessionManagement (sm -> {
//                            sm.sessionCreationPolicy(SessionCreationPolicy.STATELESS);
//                        });
//
//        http
//                .httpBasic (basic ->{
//                    basic.disable();
//                })
//                .csrf ( csrf ->{
//                    csrf.disable();
//                })
//                .formLogin ( form ->{
//                    form.disable();
//                })
//                .addFilterBefore(
//                new FilterUserController(),
//                UsernamePasswordAuthenticationFilter.class
//                )
//                .authorizeHttpRequests (authorize ->{
//                authorize.requestMatchers("/swagger-ui/**").permitAll();
//                })
//                  ;
//
//        return http.build();
//    }
//}
