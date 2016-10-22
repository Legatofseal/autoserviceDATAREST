package com.autoservice.rest;

import com.autoservice.model.Carmanufacture;
import com.autoservice.model.TypeVehicle;
import com.autoservice.service.CarmanufactureService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Legat on 10/21/2016.
 */
@RestController
@RequestMapping(value = "carmanuf")
public class CarmanufactureController {
    private final CarmanufactureService carmanufactureService;

    public CarmanufactureController(CarmanufactureService carmanufactureService) {
        this.carmanufactureService = carmanufactureService;
    }

    //Create new Carmanufacture
    @RequestMapping(value = "/put", method = RequestMethod.PUT)
    public void create(@RequestBody Carmanufacture carmanufacture) {
        carmanufactureService.create(carmanufacture);
    }


    //Get Carmanufacture by ID
    @RequestMapping(value = "/getbyid/{id}", method = RequestMethod.GET)
    public Carmanufacture getById(@PathVariable("id") Long id) {

        return carmanufactureService.get(id);
    }

    //get all Carmanufactures
    @RequestMapping(value = "/getall", method = RequestMethod.GET)
    public List<Carmanufacture> getAll() {

        return carmanufactureService.getAll();
    }
}
