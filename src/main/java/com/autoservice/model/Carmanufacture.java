package com.autoservice.model;

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
    long id;

    @Column
    String name;

    @OneToMany(mappedBy = "carmanufacture")
    private Set<Vehicle> vehicles = new HashSet<Vehicle>();

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "typeVehicles")
    Set<Contractor> contractor= new HashSet<Contractor>();
}
