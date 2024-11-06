package com.ra.model.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class UserLoginRequestDTO {
    private String username;
    private String password;
}
