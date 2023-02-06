package com.ticket.transport.model.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor @NoArgsConstructor
@Data
public class AccountRequest {
    private Long id;

    private String username;

    private String password;

    private String firstName;

    private String lastName;

    private String image;

    private Date dateOfBirth;

    private String email;

    private String phone;

    private String gender;

    private String active;

    private Long roleId;
}
