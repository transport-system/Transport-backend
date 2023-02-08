package com.ticket.transport.model.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.sql.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class LoginResponse {
    private Long id;
    private String username;
    private String roleName;
    private String firstName;
    private String lastName;
    private String avatarImage;
    private Date dateOfBirth;
    private String email;
    private String phone;
    private String gender;
    private String active;
    private String token;
    private String refreshToken;
}
