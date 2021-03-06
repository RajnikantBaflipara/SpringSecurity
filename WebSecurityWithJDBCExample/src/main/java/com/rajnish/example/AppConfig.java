package com.rajnish.example;

import org.springframework.context.annotation.Bean;  
import org.springframework.context.annotation.ComponentScan;  
import org.springframework.context.annotation.Configuration;  
import org.springframework.context.annotation.Import;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;  
import org.springframework.web.servlet.view.InternalResourceViewResolver;  
import org.springframework.web.servlet.view.JstlView;  
  
@EnableWebMvc  
@Configuration  
@ComponentScan({ "com.rajnish.*" })  
@Import({ WebSecurityConfig.class })
public class AppConfig {  
	
	@Bean(name = "dataSource")
    public DriverManagerDataSource dataSource() {
        DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
        driverManagerDataSource.setDriverClassName("org.postgresql.Driver");
        driverManagerDataSource.setUrl("jdbc:postgresql://localhost:5432/springsecurity");
        driverManagerDataSource.setUsername("postgres");
        driverManagerDataSource.setPassword("123456r");
        return driverManagerDataSource;
    }
	
    @Bean  
    public InternalResourceViewResolver viewResolver() {  
        InternalResourceViewResolver viewResolver  
                          = new InternalResourceViewResolver();  
        viewResolver.setViewClass(JstlView.class);  
        viewResolver.setPrefix("/WEB-INF/views/");  
        viewResolver.setSuffix(".jsp");  
        return viewResolver;  
    }  
}  
