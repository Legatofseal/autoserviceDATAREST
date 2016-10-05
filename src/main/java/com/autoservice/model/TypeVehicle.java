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



}
