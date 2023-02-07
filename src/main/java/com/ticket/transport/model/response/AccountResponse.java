package com.ticket.transport.model.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.sql.Date;

@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)

@AllArgsConstructor @NoArgsConstructor
@Getter @Setter
public class AccountResponse {
    private Integer id;
    private String username;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Integer roleId;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String roleName;
    private String firstName;
    private String lastName;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String avatarImage;
    private Long dateOfBirth;
    private String email;
    private String phone;
    private String gender;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String status;
}
