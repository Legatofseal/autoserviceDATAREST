package com.autoservice.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.sql.Date;

/**
 * Created by Legat on 10/13/2016.
 */

@Entity
public class Comment implements Comparable<Comment> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "client_id")
    Client client;

    public Comment() {
    }

    @ManyToOne

    @JoinColumn(name = "contractor_id")
    Contractor contractor;

    @Column
    String comment;

    @Column
    Integer value;

    @Column
    Date date;

    public Comment(Client client, Contractor contractor, String comment, Integer value) {
        this.client = client;
        this.contractor = contractor;
        this.comment = comment;
        this.value = value;
        long time = System.currentTimeMillis();

        this.date = new Date(time);
    }

    public Comment(Client client, String comment, Integer value) {
        this.client = client;
        this.comment = comment;
        this.value = value;
        long time = System.currentTimeMillis();

        this.date = new Date(time);
    }

    public Comment(Contractor contractor, String comment, Integer value) {
        this.contractor = contractor;
        this.comment = comment;
        this.value = value;


        long time = System.currentTimeMillis();

        this.date = new Date(time);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @JsonIgnore
    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
    @JsonIgnore
    public Contractor getContractor() {
        return contractor;
    }

    public void setContractor(Contractor contractor) {
        this.contractor = contractor;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public int compareTo(Comment c) {
        if (this.getId() < c.getId())
            return 1;
        else if (this.getId() > c.getId())
            return -1;
        else
            return 0;
    }
}
