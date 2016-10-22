package com.autoservice.rest;

import com.autoservice.model.TypeVehicle;
import com.autoservice.service.TypeVehicleService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Legat on 10/21/2016.
 */
@RestController
@RequestMapping(value = "typevehicle")
public class TypeVehicleController {
    private final TypeVehicleService typeVehicleService;

    public TypeVehicleController(TypeVehicleService typeVehicleService) {
        this.typeVehicleService = typeVehicleService;
    }

//Create new typeVehicle
    @RequestMapping(value = "/put", method = RequestMethod.PUT)
    public void create(@RequestBody TypeVehicle typeVehicle) {
        typeVehicleService.create(typeVehicle);
    }

    //Get typeVehicle by id
    @RequestMapping(value = "/getbyid/{id}", method = RequestMethod.GET)
    public TypeVehicle getById(@PathVariable("id") Long id) {

        return typeVehicleService.get(id);
    }

    //get all typeVehicles
    @RequestMapping(value = "/getall", method = RequestMethod.GET)
    public List<TypeVehicle> getAll() {

        return typeVehicleService.getAll();
    }
}
