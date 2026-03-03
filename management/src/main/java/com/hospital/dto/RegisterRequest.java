package com.hospital.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegisterRequest {

    private String username;
    private String email;
    private String password;
    private String role;  // PATIENT / DOCTOR / ADMIN
}