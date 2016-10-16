package com.autoservice.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Legat on 10/13/2016.
 */
@Entity
public class Rangeworks {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    String name;

    @OneToMany(mappedBy = "rangeworks")
    private Set<Subworks> subworks = new HashSet<>();

    @Column
    String url;

    @Column
    String avatar;

    @ManyToOne
    @JoinColumn(name = "contractor_id")
    Contractor contractor;

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

    public Set<Subworks> getSubworks() {
        return subworks;
    }

    public void setSubworks(Set<Subworks> subworks) {
        this.subworks = subworks;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public Contractor getContractor() {
        return contractor;
    }

    public void setContractor(Contractor contractor) {
        this.contractor = contractor;
    }
}
