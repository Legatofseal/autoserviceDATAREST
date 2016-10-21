package com.autoservice.service;

import com.autoservice.exception.NotFoundException;
import com.autoservice.model.TypeService;
import com.autoservice.model.TypeVehicle;
import com.autoservice.repo.TypeServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Legat on 10/21/2016.
 */
@Service
public class TypeServiceService {
    private final TypeServiceRepository typeServiceRepository;
    @Autowired
    public TypeServiceService(TypeServiceRepository typeServiceRepository) {
        this.typeServiceRepository = typeServiceRepository;
    }


    public TypeService get(Long id) {
        TypeService typeService = typeServiceRepository.findOne(id);
        if (typeService == null) {
            throw new NotFoundException("TypeService", id);
        }
        return typeService;
    }

    public void create (TypeService typeService){
        typeServiceRepository.save(typeService);
    }
    public List<TypeService> getAll(){
        return (List<TypeService>) typeServiceRepository.findAll();
    }
}
