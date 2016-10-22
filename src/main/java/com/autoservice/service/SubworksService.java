package com.autoservice.service;

import com.autoservice.exception.NotFoundException;
import com.autoservice.model.Rangeworks;
import com.autoservice.model.Subworks;
import com.autoservice.repo.RangeworksRepository;
import com.autoservice.repo.SubworksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Legat on 10/22/2016.
 */
@Service
public class SubworksService {
    private final SubworksRepository subworksRepository;

    @Autowired
    public SubworksService(SubworksRepository subworksRepository) {
        this.subworksRepository = subworksRepository;
    }


    public Subworks get(Long id) {
        Subworks subworks = subworksRepository.findOne(id);
        if (subworks == null) {
            throw new NotFoundException("Subworks", id);
        }
        return subworks;
    }

    public void create(Subworks subworks) {
        subworksRepository.save(subworks);
    }

    public List<Subworks> getAll() {
        return (List<Subworks>) subworksRepository.findAll();
    }
}
