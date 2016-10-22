package com.autoservice.service;

import com.autoservice.exception.NotFoundException;
import com.autoservice.model.Client;
import com.autoservice.model.Rangeworks;
import com.autoservice.model.Subworks;
import com.autoservice.model.Vehicle;
import com.autoservice.repo.RangeworksRepository;
import com.autoservice.repo.SubworksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Legat on 10/21/2016.
 */
@Service
public class RangeworksService {
    private final RangeworksRepository rangeworksRepository;
    private final SubworksRepository subworkRepository;

    @Autowired
    public RangeworksService(RangeworksRepository rangeworksRepository, SubworksRepository subworkRepository) {
        this.rangeworksRepository = rangeworksRepository;
        this.subworkRepository = subworkRepository;
    }

    public Rangeworks get(Long id) {
        Rangeworks rangework = rangeworksRepository.findOne(id);
        if (rangework == null) {
            throw new NotFoundException("Rangeworks", id);
        }
        return rangework;
    }

    public void create(Rangeworks rangeworks) {
        rangeworksRepository.save(rangeworks);
    }

    public List<Rangeworks> getAll() {
        return (List<Rangeworks>) rangeworksRepository.findAll();
    }

    public void addSubwork(Long idrw, Long idsw) {
        Rangeworks rangework = rangeworksRepository.findOne(idrw);
        rangework.getSubworks().add(subworkRepository.findOne(idsw));
        rangeworksRepository.save(rangework);

    }

    public void remoSubwork(Long idrw, Long idsw) {
        Rangeworks rangeworks = rangeworksRepository.findOne(idrw);
        for (Subworks subwork :rangeworks.getSubworks()){
            if (rangeworks.getId().equals(idsw)){
                rangeworks.getSubworks().remove(subwork);
            }
        }
        rangeworksRepository.save(rangeworks);
    }
}
