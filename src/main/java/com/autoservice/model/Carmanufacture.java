package com.autoservice.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Legat on 10/18/2016.
 */
@Entity
public class Carmanufacture {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    String name;

    @OneToMany(mappedBy = "carmanufacture")
    private Set<Vehicle> vehicles = new HashSet<Vehicle>();

    @JsonIgnore
    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "typeVehicles")
    Set<Contractor> contractor= new HashSet<Contractor>();

    public Carmanufacture() {
    }

    public Carmanufacture(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Vehicle> getVehicles() {
        return vehicles;
    }

    public void setVehicles(Set<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }

    public Set<Contractor> getContractor() {
        return contractor;
    }

    public void setContractor(Set<Contractor> contractor) {
        this.contractor = contractor;
    }
}
