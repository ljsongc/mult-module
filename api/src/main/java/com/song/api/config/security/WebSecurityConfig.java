package com.song.api.config.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


/**
 * @author 宋利军
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true, jsr250Enabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        super.configure(http);
        // @formatter:off
//        http
//                .requestMatchers().anyRequest()
//                .and()
//                .authorizeRequests()
//                .antMatchers("/oauth/*").permitAll();
        // @formatter:on
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().
                passwordEncoder(new BCryptPasswordEncoder()).
                withUser("root").
                password(new BCryptPasswordEncoder().encode("root")).
                roles("ROOT","USER").
                and().
                withUser("user").
                password(new BCryptPasswordEncoder().encode("user")).
                roles("USER");

    }
}
