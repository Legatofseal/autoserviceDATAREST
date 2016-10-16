package com.autoservice.model;

import javax.persistence.*;

/**
 * Created by Legat on 10/13/2016.
 */
@Entity
public class Subworks {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column
    String name;

    @ManyToOne
    @JoinColumn(name = "rangeworks_id")
    Rangeworks rangeworks;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Rangeworks getRangeworks() {
        return rangeworks;
    }

    public void setRangeworks(Rangeworks rangeworks) {
        this.rangeworks = rangeworks;
    }
}


