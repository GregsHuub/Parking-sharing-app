package com.GregsApp.security;

import com.GregsApp.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class WebConfig extends WebSecurityConfigurerAdapter {

    private UserRepository userRepository;


    @Autowired
    public WebConfig(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();

        http.authorizeRequests()
                .antMatchers("/api**").permitAll()
                .antMatchers("/admins**").permitAll()
                .antMatchers("/api/main").permitAll()
                .antMatchers("/api/users/*/enable").permitAll()
                .antMatchers("/landing_page.jsp**").permitAll()
                .anyRequest().permitAll();

        http.formLogin()
                .usernameParameter("email")
                .passwordParameter("password")
                .successForwardUrl("/api/main") // glowna strona, moze do zmiany todo
                .defaultSuccessUrl("/api/main")
                .loginPage("/api/main")
                .permitAll();

        http.logout()
                .logoutUrl("/logut")
                .permitAll()
                .logoutSuccessUrl("/api/main");
    }

        @Bean
        @Override
        protected UserDetailsService userDetailsService() {
            return new UserDetailsServiceImpl(userRepository);
        }

        @Bean
        public PasswordEncoder passwordEncoder(){
            return new BCryptPasswordEncoder(10);
        }
            @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("USER").password("pass").roles("USER").and()
                .withUser("ADMIN").password("password").roles("ADMIN");
    }
    }
