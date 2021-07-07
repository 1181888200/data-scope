package com.lwl.data.scope;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class DemoDataScopeApplication {

    public static void main(String[] args) {
        new SpringApplicationBuilder(DemoDataScopeApplication.class)
                .run(args);
    }
}
