package com.autoservice.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.HashSet;
import java.util.HashSet;
import java.util.Set;
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

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "subworks")
    Set<Rangeworks> rangeworks = new HashSet<Rangeworks>();

    public Subworks() {
    }

    public Subworks(String name) {
        this.name = name;
    }

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


    @JsonIgnore
    public Set<Rangeworks> getRangeworks() {
        return rangeworks;
    }

    public void setRangeworks(Set<Rangeworks> rangeworks) {
        this.rangeworks = rangeworks;
    }
}


