package com.autoservice.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Legat on 9/19/2016.
 */
@Entity
public class TypeVehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToMany(mappedBy = "typeVehicle")
    private Set<Vehicle> vehicles = new HashSet<Vehicle>();

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "typeVehicles")
    Set<Contractor> contractor= new HashSet<Contractor>();



    @Column
    String typeName;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


    public Set<Contractor> getContractor() {
        return contractor;
    }

    public void setContractor(Set<Contractor> contractor) {
        this.contractor = contractor;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public Set<Vehicle> getVehicles() {
        return vehicles;
    }

    public void setVehicles(Set<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }

    public Set<Contractor> getContractors() {
        return contractor;
    }

    public void setContractors(Set<Contractor> contractors) {
        this.contractor = contractors;
    }
}
