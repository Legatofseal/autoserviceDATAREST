package com.autoservice.service;

import com.autoservice.exception.AlreadyExistsException;
import com.autoservice.exception.NotFoundException;
import com.autoservice.model.Client;
import com.autoservice.model.TypeVehicle;
import com.autoservice.model.Vehicle;
import com.autoservice.repo.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Legat on 9/28/2016.
 */
@Service
public class VehicleService {
    private  final VehicleRepository vehicleRepository;
    @Autowired
    public VehicleService(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }
    public Vehicle get(Long id) {
        Vehicle vehicle = vehicleRepository.findOne(id);
        if (vehicle == null) {
            throw new NotFoundException("Vehicle", id);
        }
        return vehicle;
    }
    public List<Vehicle> getAll(){
        return (List<Vehicle>) vehicleRepository.findAll();
    }


    public Vehicle create(Vehicle vehicle) {


        // Example of custom logic
        if (vehicle.getId() != null && vehicleRepository.findOne(vehicle.getId()) != null) {
            throw new AlreadyExistsException("Client", vehicle.getId());
        }

        Vehicle result = vehicleRepository.save(vehicle);
        return result;
    }
    public void deleteById(Long id){
        vehicleRepository.deleteById(id);
    }
}
