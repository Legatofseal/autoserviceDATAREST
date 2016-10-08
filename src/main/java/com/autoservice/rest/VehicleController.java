package com.autoservice.rest;

import com.autoservice.model.Client;
import com.autoservice.model.TypeVehicle;
import com.autoservice.model.Vehicle;
import com.autoservice.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
    public Vehicle addVehicle() {
        Vehicle vehicle = new Vehicle();
        vehicle.setCarModel("Honda1");
        TypeVehicle typeVehicle = new TypeVehicle();
        typeVehicle.setTxtVehicleName("bigvehicle1");
        // TypeVehicle  test = new TypeVehicle();
        vehicle.setTypeVehicle(typeVehicle);
        return vehicleService.create(vehicle);
    }

    @RequestMapping(value = "/deletevehicle/{id}", method = RequestMethod.DELETE)
    public void deleteVehicle(@PathVariable("id") Long id) {
        vehicleService.deleteById(id);

    }
}
