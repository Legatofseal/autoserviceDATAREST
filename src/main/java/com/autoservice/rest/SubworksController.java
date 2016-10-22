package com.autoservice.rest;

import com.autoservice.model.Rangeworks;
import com.autoservice.model.Subworks;
import com.autoservice.service.SubworksService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Legat on 10/22/2016.
 */
@RestController
@RequestMapping(value = "subworks")
public class SubworksController {
    private final SubworksService subworksService;

    public SubworksController(SubworksService subworksService) {
        this.subworksService = subworksService;
    }

    //Create new Subworks
    @RequestMapping(value = "/put", method = RequestMethod.PUT)
    public void create(@RequestBody Subworks subworks) {
        subworksService.create(subworks);
    }

    //Get Subworks  by ID
    @RequestMapping(value = "/getbyid/{id}", method = RequestMethod.GET)
    public Subworks getById(@PathVariable("id") Long id) {

        return subworksService.get(id);
    }
    //get all subworks
    @RequestMapping(value = "/getall", method = RequestMethod.GET)
    public List<Subworks> getAll() {

        return subworksService.getAll();
    }
}
