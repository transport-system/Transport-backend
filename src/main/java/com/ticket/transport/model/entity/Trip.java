package com.ticket.transport.model.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "trip")
public class Trip {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "trip_id")
    private Long id;

    @Column(name = "employee_name")
    private String employeeName;

    @Column(name = "price", nullable = false)
    private double price;

    @Column(name = "trip_image")
    private String image;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "time_departure", nullable = false)
    private Date timeDeparture;

    @Column(name = "time_arrival", nullable = false)
    private Date timeArrival;

    @Column(name = "number_seat", nullable = false)
    private int numberSeat;

    @Column(name = "status", nullable = false)
    private String status;

    @OneToMany(mappedBy = "trip",
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            fetch = FetchType.LAZY)
    private Collection<Vehicle> vehicles;


    @ManyToOne(optional = false)
    @JoinColumn(name = "route_id", referencedColumnName = "route_id")
    private Route route;

    @ManyToOne
    @JoinColumn(name = "company_id", referencedColumnName = "account_id")
    private Company company;

    @ManyToMany(mappedBy = "trips",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY)
    private Collection<Booking> bookings;
}
