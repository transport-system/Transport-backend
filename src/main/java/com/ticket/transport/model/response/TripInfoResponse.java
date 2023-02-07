package com.ticket.transport.model.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TripInfoResponse {
    private String employeeName;

    private double price;

    private String image;

    private String description;

    private Date timeDeparture;

    private Date timeArrival;

    private Date timeReturn;

    private int maxSeat;

    private int numberSeat;

    private String status;
}
