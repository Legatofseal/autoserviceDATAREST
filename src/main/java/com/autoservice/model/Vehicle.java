package com.autoservice.model;

import javax.persistence.*;

/**
 * Created by Legat on 9/19/2016.
 */
@Entity
public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "client_id")
    Client client;

    @Column
    String carManufacture;
    @Column
    String carModel;

    public TypeVehicle getTypeVehicle() {
        return typeVehicle;
    }

    public void setTypeVehicle(TypeVehicle typeVehicle) {
        this.typeVehicle = typeVehicle;
    }

    @Column

    String serial;

    @OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name="typeVehicle_id")
    TypeVehicle typeVehicle;

    public String getSerial() {
        return serial;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
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
