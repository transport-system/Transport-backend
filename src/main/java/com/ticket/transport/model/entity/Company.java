package com.ticket.transport.model.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "company_id")
    private Long id;

    @Column(name = "company_name")
    private String companyName;

    @Column(name = "description")
    private String description;

    @Column(name = "rating_score")
    private double rating;


    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "company_vehicle",
    joinColumns = @JoinColumn(name = "company_id", referencedColumnName = "company_id"),
    inverseJoinColumns = @JoinColumn(name = "vehicle_type_id", referencedColumnName = "vehicle_type_id")
    )
    private Collection<VehicleType> vehicles;

    @JsonBackReference
    @OneToMany(mappedBy = "company", fetch = FetchType.LAZY
    ,cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Trip> trips;

    @JsonManagedReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "account_id", referencedColumnName = "account_id")
    private Account account;
}
