package com.autoservice.model;

import javax.persistence.*;

/**
 * Created by Legat on 9/19/2016.
 */
@Entity
public class TypeVehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column
    long clientID;

    @Column
    Vehicle vehicle;
    @Column
    String txtVehicleName;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @ManyToOne
    @JoinColumn(name = "clientID")
    public long getClientID() {
        return clientID;
    }

    public void setClientID(long clientID) {
        this.clientID = clientID;
    }

    public String getTxtVehicleName() {
        return txtVehicleName;
    }

    public void setTxtVehicleName(String txtVehicleName) {
        this.txtVehicleName = txtVehicleName;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }


}
