package com.ra.model.dto;

import com.ra.model.entity.Role;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Set;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class UserRequestDTO {
    private String username;
    private String password;
    private Set<String> roles;
}
