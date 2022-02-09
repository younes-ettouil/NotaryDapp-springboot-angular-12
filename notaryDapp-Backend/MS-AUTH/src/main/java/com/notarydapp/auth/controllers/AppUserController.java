package com.notarydapp.auth.controllers;

import com.notarydapp.auth.dtos.RoleToUserForm;
import com.notarydapp.auth.entities.AppUser;
import com.notarydapp.auth.entities.Role;
import com.notarydapp.auth.services.AppUserService;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.NoSuchElementException;

@CrossOrigin(origins = "*")
@RestController @RequestMapping("/auth")
@AllArgsConstructor
public class AppUserController {

    private AppUserService userService;

    @PostMapping("/user")
    public ResponseEntity<AppUser> saveUser(@RequestBody AppUser user){
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/user/save").toUriString());
        return ResponseEntity.created(uri).body(userService.saveUser(user));
    }

    @PostMapping("/role")
    public ResponseEntity<Role> saveRole(@RequestBody Role role){
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/role/save").toUriString());
        return ResponseEntity.created(uri).body(userService.saveRole(role));
    }

    @GetMapping("/users")
    public ResponseEntity<?> getUsers(){
        return ResponseEntity.ok().body(userService.getUsers());
    }

    @GetMapping("/users/{username}")
    public ResponseEntity<?> getUser(@PathVariable String username){
        return ResponseEntity.ok().body(userService.getUser(username));
    }

    @PostMapping("/grant")
    public ResponseEntity<?> addRoleToUser(@RequestBody RoleToUserForm form){
        userService.addRoleToUser(form.getUsername(), form.getRoleName());
        return ResponseEntity.ok().build();
    }

    @PutMapping("/user/{id}")
    public ResponseEntity<?> update(@RequestBody AppUser user, @PathVariable Long id) {
        try {
            AppUser existUser = userService.getUserById(id);
            user.setId(id);

            return new ResponseEntity<AppUser>(userService.saveUser(user),HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/user/{id}")
    public void delete(@PathVariable Long id) {
        userService.deleteUser(id);
    }

    @Bean
    public WebMvcConfigurer corsConfigurer(){
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/*").allowedHeaders("*").allowedOrigins("*").allowedMethods("*");
            }
        };
    }
}
