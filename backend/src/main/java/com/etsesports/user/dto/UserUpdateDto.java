package com.etsesports.user.dto;

import com.etsesports.user.Role;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;

public class UserUpdateDto {
    private String username;

    @Email
    private String email;

    @Size(min = 8)
    private String password;

    private Role role;
}
