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
    private AuthenticationEntryPoint authEntryPoint;

    @Autowired
    public void setAuthEntryPoint(AuthenticationEntryPoint authEntryPoint) {
        this.authEntryPoint = authEntryPoint;
    }

    @Autowired
    public void setUserDetailsService(UserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/resources/**", "/registration", "/","/403", "/cart/**", "/show")
                .permitAll();

        http.csrf().disable().authorizeRequests()
                .antMatchers("/admin", "/remove/*", "/update/*").access("hasRole('ADMIN')")
                .and()
                .httpBasic()
                .authenticationEntryPoint(authEntryPoint)
                .and()
                .exceptionHandling().accessDeniedPage("/403");

        http.authorizeRequests()
                .antMatchers("/info").hasAnyRole("USER", "ADMIN")
                .and()
                .exceptionHandling().accessDeniedPage("/403");

        http.authorizeRequests()
                .and()
                .formLogin().loginPage("/login").defaultSuccessUrl("/")
                .failureUrl("/login?error")
                .and()
                .logout().logoutSuccessUrl("/login?logout");
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