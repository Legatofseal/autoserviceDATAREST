package com.autoservice.service;

import com.autoservice.exception.AlreadyExistsException;
import com.autoservice.exception.NotFoundException;
import com.autoservice.model.Client;
import com.autoservice.model.Contractor;
import com.autoservice.repo.ContractorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Legat on 10/15/2016.
 */
@Service
public class ContractorService {
    private final ContractorRepository contractorRepository;

    @Autowired
    public ContractorService(ContractorRepository contractorRepository) {
        this.contractorRepository = contractorRepository;
    }

    public Contractor get(Long id) {
        Contractor contractor = contractorRepository.findOne(id);
        if (contractor == null) {
            throw new NotFoundException("Contractor", id);
        }
        return contractor;
    }
    public Contractor create(Contractor contractor) {


        // Example of custom logic
        if (contractor.getId() != null && contractorRepository.findOne(contractor.getId()) != null) {
            throw new AlreadyExistsException("Contractor", contractor.getId());
        }

        Contractor result = contractorRepository.save(contractor);
        return contractor;
    }
}
