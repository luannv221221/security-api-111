package com.ra.controller;

import com.ra.model.dto.UserRequestDTO;
import com.ra.model.dto.UserResponseDTO;
import com.ra.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/admin")
public class AdminController {
    @Autowired
    private AuthService authService;
    @GetMapping
    public ResponseEntity<?> index(){
        return new ResponseEntity<>("Xin chao ADmin", HttpStatus.OK);
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping("/auth")
    public ResponseEntity<UserResponseDTO> createAccount(@RequestBody UserRequestDTO requestDTO){
        return new ResponseEntity<>(authService.create(requestDTO),HttpStatus.CREATED);
    }

    @PreAuthorize("hasAnyAuthority('ADMIN','SUB_ADMIN')")
    @GetMapping("/auth")
    public ResponseEntity<?> getAll(){
        return new ResponseEntity<>(authService.findAll(),HttpStatus.OK);
    }
}
