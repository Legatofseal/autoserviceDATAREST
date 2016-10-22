package com.autoservice.rest;

import com.autoservice.model.Client;
import com.autoservice.model.Rangeworks;
import com.autoservice.model.TypeVehicle;
import com.autoservice.model.Vehicle;
import com.autoservice.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Legat on 10/8/2016.
 */
@RestController
@RequestMapping(value = "vehicles")
public class VehicleController {
    private final VehicleService vehicleService;

    @Autowired
    public VehicleController(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }

    @RequestMapping(value = "/createvehicle/", method = RequestMethod.PUT)
    public void addVehicle(@RequestBody Vehicle vehicle) {
        vehicleService.create(vehicle);

    }

    @RequestMapping(value = "/deletevehicle/{id}", method = RequestMethod.DELETE)
    public void deleteVehicle(@PathVariable("id") Long id) {
        vehicleService.deleteById(id);

    }

    @RequestMapping(value = "/getbyid/{id}", method = RequestMethod.GET)
    public Vehicle getById(@PathVariable("id") Long id) {

        return vehicleService.get(id);
    }
    @RequestMapping(value = "/getall", method = RequestMethod.GET)
    public List<Vehicle> getAll() {

        return vehicleService.getAll();
    }
}
