package com.notarydapp.auth;

import com.notarydapp.auth.entities.AppUser;
import com.notarydapp.auth.entities.Role;
import com.notarydapp.auth.services.AppUserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;

@SpringBootApplication
public class AuthApplication {

    public static void main(String[] args) {
        SpringApplication.run(AuthApplication.class, args);
    }

    @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    CommandLineRunner run(AppUserService userService){
        return args -> {
            userService.saveRole(new Role(null, "ADMIN"));
            userService.saveRole(new Role(null, "NOTAIRE"));

            userService.saveUser(new AppUser(null, "name", "username1@org.lsi.com", "password", new ArrayList<>()));
            userService.saveUser(new AppUser(null, "name", "username2@org.lsi.com", "password", new ArrayList<>()));

            userService.addRoleToUser("username1@org.lsi.com", "ADMIN");
            userService.addRoleToUser("username2@org.lsi.com","NOTAIRE");
        };
    }
}
