package com.example.java.dto;

import com.example.java.Enum.UserStatus;
import com.example.java.model.User;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class UserCreatedRequest {

    private String userName;

    @NotNull(message = "user email can not be blank")
    private String userEmail;

    private String userAddress;

    private String userPhone;


    public User toUser() {
//        User user = new User() --> can be used instead of builder
        return User.builder().
                name(this.userName).
                email(this.userEmail).
                phoneNo(this.userPhone).
                address(this.userAddress).
                userStatus(UserStatus.ACTIVE).
                build();
    }
}
