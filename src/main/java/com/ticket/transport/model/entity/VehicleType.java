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
@Table(name = "Vehicle_type")
public class VehicleType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "vehicle_type_id")
    private Long id;

    @Column(name = "type_name", nullable = false)
    private String typeName;

    @ManyToMany(mappedBy = "vehicles",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY)
    private Collection<Company> companies;

    @OneToMany(mappedBy = "vehicleType",
    cascade = CascadeType.ALL,
    orphanRemoval = true,
    fetch = FetchType.LAZY)
    private Collection<Vehicle> vehicles;

}
