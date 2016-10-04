package com.autoservice.service;

import com.autoservice.exception.NotFoundException;
import com.autoservice.model.Client;
import com.autoservice.model.TypeVehicle;
import com.autoservice.repo.TypeVehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Legat on 9/28/2016.
 */
@Service
public class TypeVehicleService {
    private final TypeVehicleRepository typeVehicleRepository;

    @Autowired
    public TypeVehicleService(TypeVehicleRepository typeVehicleRepository) {
        this.typeVehicleRepository = typeVehicleRepository;
    }


    public TypeVehicle get(Long id) {
        TypeVehicle typeVehicle = typeVehicleRepository.findOne(id);
        if (typeVehicle == null) {
            throw new NotFoundException("TypeVehicle", id);
        }
        return typeVehicle;
    }
}
