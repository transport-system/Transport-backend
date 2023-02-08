package com.ticket.transport.model.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.math.BigDecimal;
import java.sql.Date;

@NoArgsConstructor @AllArgsConstructor
@Getter @Setter
public class BookingResponse {
    private Date appointmentDate;

    private Date expireAppointmentDate;

    private Boolean appointmentStatus;

    private Date createBookingTime;

    private Date examTime;

    private String note;

    private BigDecimal totalPrice;

    private String status;

    private String rejectedNote;
}
