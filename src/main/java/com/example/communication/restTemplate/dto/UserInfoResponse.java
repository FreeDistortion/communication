package com.example.communication.restTemplate.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class UserInfoResponse {
    private Long id;
    private String username;
    private String password;
    private String name;
}
