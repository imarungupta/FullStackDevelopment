package com.student.enrolement.system.service;

import org.springframework.stereotype.Component;

@Component
public class EagerLoadingBean {
    public EagerLoadingBean() {
        System.out.println("Eager Load Bean is created..");
    }
}
