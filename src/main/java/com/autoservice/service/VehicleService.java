package com.autoservice.service;

import com.autoservice.exception.NotFoundException;
import com.autoservice.model.TypeVehicle;
import com.autoservice.model.Vehicle;
import com.autoservice.repo.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
