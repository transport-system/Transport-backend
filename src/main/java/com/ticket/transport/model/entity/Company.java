package com.ticket.transport.model.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "company")
@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
@PrimaryKeyJoinColumn(name = "account_id")
public class Company extends Account {

    @Column(name = "company_name", nullable = false)
    private String companyName;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "rating_score", nullable = false)
    private double rating;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "company_vehicle",
    joinColumns = @JoinColumn(name = "company_id", referencedColumnName = "account_id"),
    inverseJoinColumns = @JoinColumn(name = "vehicle_type_id", referencedColumnName = "vehicle_type_id")
    )
    private Collection<VehicleType> vehicles;

    @OneToMany(mappedBy = "company", fetch = FetchType.LAZY
    ,cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Trip> trips;
}
