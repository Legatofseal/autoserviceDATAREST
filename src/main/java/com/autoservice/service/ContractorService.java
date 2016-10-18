package com.autoservice.service;

import com.autoservice.exception.AlreadyExistsException;
import com.autoservice.exception.NotFoundException;
import com.autoservice.model.Contractor;
import com.autoservice.model.Rangeworks;
import com.autoservice.repo.ContractorRepository;
import com.autoservice.repo.RangeworksRepository;
import com.autoservice.repo.TypeServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Legat on 10/15/2016.
 */
@Service
public class ContractorService {
    private final ContractorRepository contractorRepository;
    private final TypeServiceRepository typeServiceRepository;
    private final RangeworksRepository rangeworksRepository;

    @Autowired
    public ContractorService(ContractorRepository contractorRepository, TypeServiceRepository typeServiceRepository, RangeworksRepository rangeworksRepository) {
        this.contractorRepository = contractorRepository;
        this.typeServiceRepository = typeServiceRepository;
        this.rangeworksRepository = rangeworksRepository;
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

    public List<Contractor> getByTypeService(Long id) {
         return contractorRepository.findByTypeServices(typeServiceRepository.findOne(id));
    }
    public List<Contractor> getByRangeworks(Long id) {
        return contractorRepository.findByRangeworks(rangeworksRepository.findOne(id));
    }
    public List<Rangeworks> getAllRange(){
        return (List<Rangeworks>) rangeworksRepository.findAll();
    }
}
