package com.ra.service;

import com.ra.model.dto.UserLoginRequestDTO;
import com.ra.model.dto.UserLoginResponseDTO;
import com.ra.model.dto.UserRequestDTO;
import com.ra.model.dto.UserResponseDTO;

import java.util.List;

public interface AuthService {
    UserLoginResponseDTO login(UserLoginRequestDTO userLoginRequestDTO);

    UserResponseDTO create(UserRequestDTO requestDTO);

    List<UserResponseDTO> findAll();
}
