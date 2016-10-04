package com.autoservice.model;

import javax.persistence.*;

/**
 * Created by Legat on 9/19/2016.
 */
@Entity
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    @Column
    String area;

    @Column
    String city;

    @Column
    String street;

    @Column
    int house;

    @Column
    String txt_address;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public int getHouse() {
        return house;
    }

    public void setHouse(int house) {
        this.house = house;
    }

    public String getTxt_address() {
        return txt_address;
    }

    public void setTxt_address(String txt_address) {
        this.txt_address = txt_address;
    }

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", area='" + area + '\'' +
                ", city='" + city + '\'' +
                ", street='" + street + '\'' +
                ", house=" + house +
                '}';
    }
}
