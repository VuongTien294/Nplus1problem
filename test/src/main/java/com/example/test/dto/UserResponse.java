package com.example.test.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class UserResponse {
    private String name;
    private String companyName;
}
