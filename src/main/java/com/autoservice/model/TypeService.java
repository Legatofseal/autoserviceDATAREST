package com.autoservice.model;

import javax.persistence.*;
import java.util.HashSet;

/**
 * Created by Legat on 10/13/2016.
 */

@Entity
public class TypeService {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column
    String name;
    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "typeVehicles")
    Set<Contractor> contractor = new HashSet<Contractor>();
}
