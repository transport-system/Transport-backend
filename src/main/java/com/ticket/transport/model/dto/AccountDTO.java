package com.ticket.transport.model.dto;

import lombok.*;

import java.util.Date;

@AllArgsConstructor @NoArgsConstructor
@Getter @Setter
public class AccountDTO {
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
