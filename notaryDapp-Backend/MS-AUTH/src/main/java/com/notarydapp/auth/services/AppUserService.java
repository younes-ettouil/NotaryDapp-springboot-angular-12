package com.notarydapp.auth.services;

import com.notarydapp.auth.entities.Role;
import com.notarydapp.auth.entities.AppUser;

import java.util.List;

public interface AppUserService {
    AppUser saveUser(AppUser user);
    Role saveRole(Role role);
    void addRoleToUser(String username, String roleName);
    AppUser getUser(String username);
    List<AppUser> getUsers();
    AppUser getUserById(Long id) ;
    void deleteUser(Long id);

}
