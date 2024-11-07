package com.ra.model.dto;

import com.ra.model.entity.Role;
import lombok.*;

import java.util.Set;
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class UserResponseDTO {
    private Long id;
    private String username;
    private String Status;
    private Set<Role> roles;
}
