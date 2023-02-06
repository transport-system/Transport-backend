package com.ticket.transport.model.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.ticket.transport.model.entity.Booking;
import com.ticket.transport.model.entity.FeedBack;
import lombok.*;

import java.util.Date;
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)

@AllArgsConstructor @NoArgsConstructor
@Getter @Setter
public class AccountResponse {
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

//    @JsonInclude(JsonInclude.Include.NON_NULL)
    private BookingResponse bookings;
}
