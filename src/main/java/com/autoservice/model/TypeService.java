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
public class TypeService {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;


    @Column
    String name;
    @JsonIgnore
    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "typeServices")
    Set<Contractor> contractor = new HashSet<Contractor>();

    public TypeService() {
    }

    public TypeService(String name) {
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

    public Set<Contractor> getContractor() {
        return contractor;
    }

    public void setContractor(Set<Contractor> contractor) {
        this.contractor = contractor;
    }
}
