package com.autoservice.rest;

import com.autoservice.model.*;
import com.autoservice.service.ContractorService;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
    public void create() {
        Subworks subworks1 = new Subworks("s1");
        Subworks subworks2 = new Subworks("s2");
        Subworks subworks3 = new Subworks("s3");
        Subworks subworks4 = new Subworks("s4");
        Rangeworks rangeworks1 = new Rangeworks("r1");
        Rangeworks rangeworks2 = new Rangeworks("r2");
        rangeworks1.getSubworks().add(subworks1);
        rangeworks1.getSubworks().add(subworks2);
        rangeworks2.getSubworks().add(subworks3);
        rangeworks2.getSubworks().add(subworks4);
        Contractor contractor1 = new Contractor("c1");
        Contractor contractor2 = new Contractor("c2");
        contractor1.getRangeworks().add(rangeworks1);
        contractor2.getRangeworks().add(rangeworks2);
        contractorService.create(contractor1);
        contractorService.create(contractor2);

    }

    @RequestMapping(value = "/getbyid/{id}", method = RequestMethod.GET)
    public Contractor getById(@PathVariable("id") Long id) {

        return contractorService.get(id);
    }

    @RequestMapping(value = "/getbytypeservice/{id}", method = RequestMethod.GET)
    public List<Contractor> getByTypeOfService(@PathVariable("id") Long id) {

        return contractorService.getByTypeService(id);
    }

    @RequestMapping(value = "/getbyrangeworks/{id}", method = RequestMethod.GET)
    public List<Contractor> getByRangeworks(@PathVariable("id") Long id) {

        return contractorService.getByRangeworks(id);
    }

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public List<Rangeworks> getAllRange() {

        return contractorService.getAllRange();
    }
}
