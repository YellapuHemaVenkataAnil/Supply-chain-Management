package com.scm;

import com.scm.service.AuthService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SupplyChainApplication {

    public static void main(String[] args) {
        SpringApplication.run(SupplyChainApplication.class, args);
    }

    @Bean
    CommandLineRunner init(AuthService authService) {
        return args -> {
            // Create default admin user on startup
            authService.createAdminUser();
            System.out.println("✅ Default admin created: admin@scm.com / admin123");
        };
    }
}