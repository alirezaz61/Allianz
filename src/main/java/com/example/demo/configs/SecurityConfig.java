package com.example.demo.configs;


import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.servlet.http.Cookie;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        PasswordEncoder encoder =
                PasswordEncoderFactories.createDelegatingPasswordEncoder();
        auth
                .inMemoryAuthentication()

                .withUser("enrique")
                .password(encoder.encode("enrique"))
                .roles("USER")
                .and()
                .withUser("stephan")
                .password(encoder.encode("stephan"))
                .roles("USER")
                .and()
                .withUser("thomas")
                .password(encoder.encode("thomas")).roles("USER")

                .and()
                .withUser("sen1")
                .password(encoder.encode("password")).roles("SENSOR")
                .and()
                .withUser("sen2")
                .password(encoder.encode("password")).roles("SENSOR")
                .and()
                .withUser("sen3")
                .password(encoder.encode("password")).roles("SENSOR")
                .and()
                .withUser("sen4")
                .password(encoder.encode("password")).roles("SENSOR")
                .and()
                .withUser("sen5")
                .password(encoder.encode("password")).roles("SENSOR")
        ;

    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/receiver/**").permitAll()
                .anyRequest()
                .authenticated()
                .and()

                .httpBasic()
//                .formLogin()
//                .defaultSuccessUrl("/cityhalls")
//                .permitAll()
//                .and()
//
//                .logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
//                .logoutSuccessUrl("/login")
                ;

    }
}


