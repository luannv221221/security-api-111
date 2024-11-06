package com.ra.model.dto;

import com.ra.model.entity.Role;
import lombok.*;

import java.util.Set;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class UserLoginResponseDTO {
    private String userName;
    private String accessToken;
    private String typeToken;
    private Set<Role> roles;
}
