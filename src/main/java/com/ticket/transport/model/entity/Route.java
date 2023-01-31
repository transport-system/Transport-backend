package com.ticket.transport.model.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Collection;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "route")
public class Route {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "route_id")
    private Long id;

    @OneToOne
    @JoinColumn(name = "city_arrival_id", referencedColumnName = "city_id")
    private City city1;

    @OneToOne
    @JoinColumn(name = "city_departure_id", referencedColumnName = "city_id")
    private City city2;


    @OneToMany(mappedBy = "route", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    private Collection<Trip> trips;

}
