package com.student.enrolement.system.service;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Lazy
public class LazyLoadBean {
    public LazyLoadBean(){
        System.out.println("Lazy Load bean is created on demand");
    }
}
