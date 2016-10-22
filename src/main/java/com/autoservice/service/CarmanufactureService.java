package com.autoservice.service;

import com.autoservice.exception.NotFoundException;
import com.autoservice.model.Carmanufacture;
import com.autoservice.model.Rangeworks;
import com.autoservice.repo.CarmanufactureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Legat on 10/21/2016.
 */
@Service
public class CarmanufactureService {
    private final CarmanufactureRepository carmanufactureRepository;

    @Autowired
    public CarmanufactureService(CarmanufactureRepository carmanufactureRepository) {
        this.carmanufactureRepository = carmanufactureRepository;
    }
    public Carmanufacture get(Long id) {
        Carmanufacture carmanufacture = carmanufactureRepository.findOne(id);
        if (carmanufacture == null) {
            throw new NotFoundException("Carmanufacture", id);
        }
        return carmanufacture;
    }

    public void create(Carmanufacture carmanufacture) {
        carmanufactureRepository.save(carmanufacture);
    }

    public List<Carmanufacture> getAll() {
        return (List<Carmanufacture>) carmanufactureRepository.findAll();
    }
}
