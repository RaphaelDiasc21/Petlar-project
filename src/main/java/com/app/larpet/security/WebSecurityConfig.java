package com.app.larpet.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {


    @Qualifier("userAuthService")
    @Autowired
    UserDetailsService us;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception{
        auth.userDetailsService(us).passwordEncoder(passwordEncoder());

        // Mock Authentication
        auth.inMemoryAuthentication()
                .withUser("duzin")
                .password( passwordEncoder().encode("123"))
                .roles("USER")
            .and()
                .withUser("raph")
                .password( passwordEncoder().encode("123"))
                .roles("USER");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception{
        http.csrf().disable().authorizeRequests()
        .antMatchers("/post-inserir").hasRole("USER")
        .antMatchers("/h2-console/**").permitAll()
        .antMatchers("/**").permitAll()
        .anyRequest().authenticated()
        .and().formLogin()
        .loginPage("/entrar").usernameParameter("email")
        .passwordParameter("senha").loginProcessingUrl("/entrar-usuario")
        .permitAll();

        http.headers().frameOptions().disable();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}