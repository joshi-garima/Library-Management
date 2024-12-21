package com.example.java.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class UserCreatedResponse {

    private String userName;

    private String userEmail;

    private String userAddress;

    private String userPhone;
}
