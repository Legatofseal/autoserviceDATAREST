package com.autoservice.model;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by Legat on 9/19/2016.
 */
@Entity
public class TypeVehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name = "vehicle_id")
    Vehicle vehicle;

    @ManyToOne
    @JoinColumn(name = "contractor_id")
    Contractor contractor;



    @Column
    String txtVehicleName;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public Contractor getContractor() {
        return contractor;
    }

    public void setContractor(Contractor contractor) {
        this.contractor = contractor;
    }

}
