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

        Contractor contractor1 = new Contractor("c1");
        TypeService typeService = new TypeService("all");
        TypeVehicle typeVehicle = new TypeVehicle("car1");
        TypeVehicle typeVehicle1 = new TypeVehicle("car2");
        TypeVehicle typeVehicle2 = new TypeVehicle("car3");
        Carmanufacture carmanufacture = new Carmanufacture("Honda");
        contractor1.getTypeServices().add(typeService);
        contractor1.getTypeVehicles().add(typeVehicle1);
      //  contractor1.getTypeVehicles().add(typeVehicle);
        contractor1.getCarmanufacture().add(carmanufacture);

        contractorService.create(contractor1);


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

    @RequestMapping(value = "/getbycarmanuf/{id}", method = RequestMethod.GET)
    public List<Contractor> getByCarmanuf(@PathVariable("id") Long id) {

        return contractorService.getByCarmanuf(id);
    }

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public List<Rangeworks> getAllRange() {

        return contractorService.getAllRange();
    }
}
