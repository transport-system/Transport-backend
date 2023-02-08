package com.ticket.transport.model.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CompanyResponse {
    private String companyName;

    private String description;

    private double rating;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private AccountResponse account;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private TripInfoResponse trip;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private VehicleTypeInfoResponse vehicle;
}
