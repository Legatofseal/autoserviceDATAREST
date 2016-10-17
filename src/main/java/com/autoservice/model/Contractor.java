package com.autoservice.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Legat on 10/13/2016.
 */
@Entity
public class Contractor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    String name;

    @ManyToMany
    @JoinTable(name = "type_service_join",
            joinColumns = {@JoinColumn(name = "contractor_id") },
            inverseJoinColumns = { @JoinColumn(name = "typeservice_id") })
    public Set<TypeService> typeServices;

    @OneToMany(mappedBy = "contractor")
    public Set<Rangeworks> rangeWorkses = new HashSet<>();

    public Set<Rangeworks> getRangeWorkses() {
        return rangeWorkses;
    }

    public void setRangeWorkses(Set<Rangeworks> rangeWorkses) {
        this.rangeWorkses = rangeWorkses;
    }

    @Column

    String email;

    @Column
    String password;

    @Column
    String phone;

    @Column
    String fax;

    @Column
    String workingDays;
    @Column
    String workingHours;

    @OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name="address_id")
    private Address address;

    @ManyToMany
    @JoinTable(name = "type_vehicle_join",
            joinColumns = {@JoinColumn(name = "contractor_id") },
            inverseJoinColumns = { @JoinColumn(name = "typevehicle_id") })
    private Set<TypeVehicle> typeVehicles = new HashSet<>();

    public Contractor() {
    }

   // @OneToMany(mappedBy = "contractor")
//    private Set<Comment> comments = new HashSet<>();

    public Contractor(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<TypeService> getTypeServices() {
        return typeServices;
    }

    public void setTypeServices(Set<TypeService> typeServices) {
        this.typeServices = typeServices;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getWorkingDays() {
        return workingDays;
    }

    public void setWorkingDays(String workingDays) {
        this.workingDays = workingDays;
    }

    public String getWorkingHours() {
        return workingHours;
    }

    public void setWorkingHours(String workingHours) {
        this.workingHours = workingHours;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Set<TypeVehicle> getTypeVehicles() {
        return typeVehicles;
    }

    public void setTypeVehicles(Set<TypeVehicle> typeVehicles) {
        this.typeVehicles = typeVehicles;
    }

 /*   public Set<Comment> getComments() {
        return comments;
    }

    public void setComments(Set<Comment> comments) {
        this.comments = comments;
    }*/
}
