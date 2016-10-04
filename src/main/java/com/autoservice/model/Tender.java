package com.autoservice.model;

import javax.persistence.*;

/**
 * Created by Legat on 9/27/2016.
 */
@Entity
public class Tender {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name = "client_id")
    Client client;

    
}
