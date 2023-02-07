package com.ticket.transport.model.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Collection;
import java.sql.Date;

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

    @Column(name = "price")
    private double price;

    @Column(name = "trip_image")
    private String image;

    @Column(name = "description")
    private String description;

    @Column(name = "time_departure")
    private Date timeDeparture;

    @Column(name = "time_arrival")
    private Date timeArrival;

    @Column(name = "time_return")
    private Date timeReturn;

    @Column(name = "max_seat")
    private int maxSeat;

    @Column(name = "number_seat")
    private int numberSeat;

    @Column(name = "status")
    private String status;

    @JsonBackReference
    @OneToMany(mappedBy = "trip",
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            fetch = FetchType.LAZY)
    private Collection<Vehicle> vehicles;


    @JsonBackReference
    @ManyToOne(optional = false)
    @JoinColumn(name = "route_id", referencedColumnName = "route_id")
    private Route route;

    @JsonManagedReference
    @ManyToOne(optional = false)
    @JoinColumn(name = "company_id", referencedColumnName = "company_id")
    private Company company;


    @ManyToMany(mappedBy = "trips",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY)
    private Collection<Booking> bookings;
}
