package com.student.enrolement.system.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
public class DBConfig {

    @Value("${db.url}")
    private String url;
    @Value("${db.username}")
    private String username;
    @Value("${db.password}")
    private String password;

    @Value("${active.profile}")
    private String activeProfile;

    @Bean
    @Profile("prod")
    public String dataSourceProps(){
        System.out.println("URL-"+url+"::"+"Username-"+username+"::"+"Password-"+password);
        System.out.println("activeProfile::"+activeProfile);
        return "DB Connection for Dev";
    }
}
