package com.project.online_shop.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    private UserDetailsService userDetailsService;

    @Autowired
    public void setUserDetailsService(UserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().antMatchers("/resources/**", "/registration", "/","/403", "/cart/**").permitAll();
        http.authorizeRequests().antMatchers("/admin", "/remove/*").access("hasRole('ADMIN')").and().exceptionHandling().accessDeniedPage("/403");
        http.csrf().disable().authorizeRequests().antMatchers("/update/*").access("hasRole('ADMIN')").and().exceptionHandling().accessDeniedPage("/403");
        http.authorizeRequests().antMatchers("/info").hasAnyRole("USER", "ADMIN").and().exceptionHandling().accessDeniedPage("/403");
//        http.csrf().disable().authorizeRequests().antMatchers("/update/*", "/update", "/show/*", "/show").permitAll();

        http.authorizeRequests()
                .and()
                .formLogin().loginPage("/login").defaultSuccessUrl("/")
                .failureUrl("/login?error")
                .and().logout().logoutSuccessUrl("/login?logout");
    }

    @Autowired
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {

        auth.inMemoryAuthentication().passwordEncoder(passwordEncoder()).withUser("admin").password(passwordEncoder().encode("a")).roles("ADMIN");
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());

    }
}