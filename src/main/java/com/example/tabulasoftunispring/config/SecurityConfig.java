package com.example.tabulasoftunispring.config;

import com.example.tabulasoftunispring.handlers.OAuth2UserAuthSuccessHandler;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;

@AllArgsConstructor
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final UserDetailsService tabulaUserDetailsService;
    private final PasswordEncoder passwordEncoder;
    private final OAuth2UserAuthSuccessHandler oAuth2UserAuthSuccessHandler;

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                .authorizeRequests()
                .requestMatchers(PathRequest.toStaticResources().atCommonLocations()).permitAll()
                .antMatchers("/login**", "/login-error**", "/registration").permitAll()
                .antMatchers("/**").authenticated()
                .and()
                    .formLogin()
                    .loginPage("/login")
                    .loginProcessingUrl("/login/authenticate")
                    .failureForwardUrl("/login-error")
                    .successForwardUrl("/home")
                .and()
                    .logout()
                    .logoutUrl("/logout")
                    .logoutSuccessUrl("/login")
                    .invalidateHttpSession(true)
                    .deleteCookies("JSESSIONID")
                .and()
                    .oauth2Login()
                    .loginPage("/login")
                    .successHandler(oAuth2UserAuthSuccessHandler);
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder authManager) throws Exception {
        authManager
                .userDetailsService(tabulaUserDetailsService)
                .passwordEncoder(passwordEncoder);
    }

}
