package com.project.online_shop;

import com.project.online_shop.service.ProductsService;
import com.project.online_shop.service.UsersService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Application {
    public static void main(String[] args) {
       SpringApplication.run(Application.class, args);
    }
}
