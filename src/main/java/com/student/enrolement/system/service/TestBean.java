package com.student.enrolement.system.service;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;
import org.springframework.http.converter.json.GsonBuilderUtils;
import org.springframework.stereotype.Component;

// We can create the object using @Component or
// let's create the object inside @Configuration annotated class using @Bean annotation
// @Component

    @Lazy
    @Data
    @PropertySource("classpath:custom.properties")
    @ConfigurationProperties(prefix = "custom")
    @Component
    @Scope("prototype")
    public class TestBean {

        //@Value(("${custom.message}"))
        private String message;

        //@Value("${first.name}")
        private String firstName;

        //@Value("${last.name}")
        private String lastName;

        public TestBean(){
            System.out.println("Lazy Load bean is created");
        }
        public void method1(){
            System.out.println("Bean is created inside configuration class");
        }
    }
