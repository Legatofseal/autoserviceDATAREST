package com.autoservice.service;

import com.autoservice.exception.NotFoundException;
import com.autoservice.model.Rangeworks;
import com.autoservice.model.TypeService;
import com.autoservice.repo.RangeworksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Legat on 10/21/2016.
 */
@Service
public class RangeworksService {
    private final RangeworksRepository rangeworksRepository;

    @Autowired
    public RangeworksService(RangeworksRepository rangeworksRepository) {
        this.rangeworksRepository = rangeworksRepository;
    }

    public Rangeworks get(Long id) {
        Rangeworks rangework = rangeworksRepository.findOne(id);
        if (rangework == null) {
            throw new NotFoundException("TypeService", id);
        }
        return rangework;
    }

    public void create(Rangeworks rangeworks) {
        rangeworksRepository.save(rangeworks);
    }

    public List<Rangeworks> getAll() {
        return (List<Rangeworks>) rangeworksRepository.findAll();
    }
}
