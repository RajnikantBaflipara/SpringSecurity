package com.rajnish.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;  
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.authentication.builders.*;  
import org.springframework.security.config.annotation.web.builders.HttpSecurity;  
import org.springframework.security.config.annotation.web.configuration.*;  
import org.springframework.security.core.userdetails.User;  
import org.springframework.security.core.userdetails.UserDetailsService;  
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;  
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer; 

import javax.sql.DataSource;

@EnableWebSecurity  
@Configuration
@Order(1000)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter  {  
    
	@Autowired
    DataSource dataSource;
	
//	@Bean  
//    public UserDetailsService userDetailsService() {  
//        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();  
//        manager.createUser(User.withDefaultPasswordEncoder()  
//        .username("irfan").password("khan").roles("ADMIN").build());  
//        return manager;  
//    }  
	@Autowired
    public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception {
        
        auth.jdbcAuthentication().dataSource(dataSource)
            .usersByUsernameQuery("select username, password, 1 as enabled from users where username=?")
            .authoritiesByUsernameQuery("select  username,role from user_roles where username=?")
            .passwordEncoder(new BCryptPasswordEncoder());;
    }   
      
    @Override  
    protected void configure(HttpSecurity http) throws Exception {  
                   
    	http.authorizeRequests().  
        antMatchers("/index","/").permitAll()  
        .antMatchers("/admin").access("hasRole('ROLE_ADMIN')")
        .and()  
        .formLogin()  
        .loginPage("/login").defaultSuccessUrl("/admin")
        .usernameParameter("username").passwordParameter("password")
        .and()  
        .logout()  
        .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
        .and()
        .exceptionHandling().accessDeniedPage("/403");  
    	
    }  
}  
