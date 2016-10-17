package com.autoservice.rest;

import com.autoservice.model.*;
import com.autoservice.service.ContractorService;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Legat on 10/16/2016.
 */
@RestController
@RequestMapping(value = "contractors")
public class ContractorController {
    private final ContractorService contractorService;

    public ContractorController(ContractorService contractorService) {
        this.contractorService = contractorService;
    }

    @RequestMapping(value = "put", method = RequestMethod.PUT)
    public Contractor create() {

        Contractor contractor = new Contractor("test", "test@test");
        return contractorService.create(contractor);
    }

    @RequestMapping(value = "/getbyid/{id}", method = RequestMethod.GET)
    public Contractor getById(@PathVariable("id") Long id) {

        return contractorService.get(id);
    }

    @RequestMapping(value = "/getbytypeservice/{id}", method = RequestMethod.GET)
    public Contractor getByTypeOfService(@PathVariable("id") Long id) {

        return contractorService.get(id);
    }

}
