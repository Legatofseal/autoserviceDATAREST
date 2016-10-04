package com.autoservice.service;

import com.autoservice.exception.AlreadyExistsException;
import com.autoservice.exception.NotFoundException;
import com.autoservice.model.Client;
import com.autoservice.model.Person;
import com.autoservice.repo.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;


/**
 * Created by Legat on 9/27/2016.
 */
@Service
public class ClientService {
    private final ClientRepository clientRepository;
    @Autowired
    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }
    public Client get(Long id) {
        Client client = clientRepository.findOne(id);
        if (client == null) {
            throw new NotFoundException("Client", id);
        }
        return client;
    }

    public List<Client> getAll() {
        // Java 8 magic!
        return StreamSupport.stream(clientRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }
    public Client create(Client client) {


        // Example of custom logic
        if (client.getId() != null && clientRepository.findOne(client.getId()) != null) {
            throw new AlreadyExistsException("Client", client.getId());
        }

        Client result = clientRepository.save(client);
        return client;
    }

}
