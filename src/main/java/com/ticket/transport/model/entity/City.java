package com.ticket.transport.model.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "city", uniqueConstraints = @UniqueConstraint(columnNames = "city_name"))
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "city_id")
    private Long id;

    @Column(name = "city_name")
    private String city;

    @OneToOne(mappedBy = "city1", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Route route1;

    @OneToOne(mappedBy = "city2", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Route route2;
}
