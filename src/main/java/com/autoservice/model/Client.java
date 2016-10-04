package com.autoservice.model;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by Legat on 9/19/2016.
 */
@Entity
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    String name;

    @Column
    String email;

    public Client(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.address = null;
    }

    public Client() {
    }

    @Column

    String password;

    @Column
    String phone;

    @OneToMany(mappedBy = "client")
    Set<TypeVehicle> typeVehicle;

    @OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name="address_id")
    Address address;

    @Column
    String avatar;

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

    public Set<TypeVehicle> getTypeVehicle() {
        return typeVehicle;
    }

    public void setTypeVehicle(Set<TypeVehicle> typeVehicle) {
        this.typeVehicle = typeVehicle;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", typeVehicle=" + typeVehicle +
                ", address=" + address +
                '}';
    }
}
