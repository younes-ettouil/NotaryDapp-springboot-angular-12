package com.notarydapp.auth.dtos;

import lombok.Data;

@Data
public class RoleToUserForm {
    private String username;
    private String roleName;
}