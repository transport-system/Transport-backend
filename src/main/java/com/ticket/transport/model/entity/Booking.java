package com.ticket.transport.model.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;

@AllArgsConstructor @NoArgsConstructor
@Getter @Setter
@Entity
@Table(name = "booking")
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "booking_id")
    private Long id;

    @Column(name = "appointment_date")
    private Date appointmentDate;

    @Column(name = "expire_appointment_date")
    private Date expireAppointmentDate;

    @Column(name = "appointment_status")
    private Boolean appointmentStatus;

    @Column(name = "create_booking_time", nullable = false)
    private Date createBookingTime;

    @Column(name = "exam_time", nullable = false)
    private Date examTime;

    @Column(name = "note")
    private String note;

    @Column(name = "total_price", nullable = false)
    private Double totalPrice;

    @Column(name = "status", nullable = false)
    private String status;

    @Column(name = "rejected_note")
    private String rejectedNote;

    @OneToMany(mappedBy = "booking", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    private Collection<FreeSeat> freeSeats;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "booking_detail",
            joinColumns = @JoinColumn(name = "booking_id", referencedColumnName = "booking_id"),
            inverseJoinColumns = @JoinColumn(name = "trip_id", referencedColumnName = "trip_id")
    )
    private Collection<Trip> trips;

    @OneToMany(mappedBy = "booking",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            orphanRemoval = true)
    private Collection<FeedBack> feedBacks;
}
