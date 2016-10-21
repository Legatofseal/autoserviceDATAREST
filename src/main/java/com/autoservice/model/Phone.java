package com.autoservice.model;

import javax.persistence.*;

/**
 * Created by Legat on 10/20/2016.
 */
@Entity
public class Phone {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    String phone;

    @ManyToOne
    @JoinColumn(name = "contractor_id")
    Contractor contractor;

    public Phone() {
    }

    public Phone(String phone) {
        this.phone = phone;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Contractor getContractor() {
        return contractor;
    }

    public void setContractor(Contractor contractor) {
        this.contractor = contractor;
    }
}
