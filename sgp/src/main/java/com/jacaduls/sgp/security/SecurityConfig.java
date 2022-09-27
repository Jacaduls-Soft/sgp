package com.jacaduls.sgp.security;

import com.jacaduls.sgp.services.MyUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {


    @Autowired
    MyUserDetailsService service;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception{
        auth.userDetailsService(service);
    }

    @Bean
    public PasswordEncoder getPasswordEncoder(){
        return NoOpPasswordEncoder.getInstance();
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception{
        http.csrf().disable();
        http.authorizeHttpRequests()

                .antMatchers("/users**").hasRole("ADMIN")
                .antMatchers("/delete/users/**").hasRole("ADMIN")
                .antMatchers("/employees*").hasRole("ADMIN")
                .antMatchers("/enterprises*").hasRole("ADMIN")
                .antMatchers("/").permitAll()
                .antMatchers("/login*").permitAll()

                .and()

                .formLogin()
                .loginPage("/login")
                .usernameParameter("correo")
                .passwordParameter("password")
                .defaultSuccessUrl("/home")

                .and()

                .logout()
                .logoutUrl("/logout")
                .logoutSuccessUrl("/");
    }
}
