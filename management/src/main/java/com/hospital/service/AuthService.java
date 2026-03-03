package com.hospital.service;

import com.hospital.dto.LoginRequest;
import com.hospital.dto.RegisterRequest;

public interface AuthService {

    String register(RegisterRequest request);

    String login(LoginRequest request);
}