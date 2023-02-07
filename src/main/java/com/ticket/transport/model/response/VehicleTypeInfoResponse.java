package com.ticket.transport.model.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class VehicleTypeInfoResponse {
    private String typeName;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private VehicleInfoResponse vehicle;
}
