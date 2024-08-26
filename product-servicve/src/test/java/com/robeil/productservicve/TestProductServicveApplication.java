package com.robeil.productservicve;

import org.springframework.boot.SpringApplication;

public class TestProductServicveApplication {

    public static void main(String[] args) {
        SpringApplication.from(ProductServicveApplication::main).with(TestcontainersConfiguration.class).run(args);
    }

}
