package com.autoservice.model;

import javax.persistence.*;

/**
 * Created by Legat on 9/19/2016.
 */
@Entity
public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @ManyToOne
    @JoinColumn(name = "typeVehicle_id")
    TypeVehicle typeVehicle;
    @Column
    String carManufacture;
    @Column
    String carModel;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public TypeVehicle getTypeVehicle() {
        return typeVehicle;
    }

    public void setTypeVehicle(TypeVehicle typeVehicle) {
        this.typeVehicle = typeVehicle;
    }

    public String getCarManufacture() {
        return carManufacture;
    }

    public void setCarManufacture(String carManufacture) {
        this.carManufacture = carManufacture;
    }

    public String getCarModel() {
        return carModel;
    }

    public void setCarModel(String carModel) {
        this.carModel = carModel;
    }


}
