package com.autoservice.model;

import javax.persistence.*;

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
    @ManyToOne
    @JoinColumn(name = "contractor_id")
    Contractor contractor;
}
