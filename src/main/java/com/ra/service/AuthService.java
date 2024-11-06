package com.ra.service;

import com.ra.model.dto.UserLoginRequestDTO;
import com.ra.model.dto.UserLoginResponseDTO;

public interface AuthService {
    UserLoginResponseDTO login(UserLoginRequestDTO userLoginRequestDTO);
}
