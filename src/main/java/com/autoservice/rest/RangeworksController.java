package com.autoservice.rest;

import com.autoservice.model.Rangeworks;
import com.autoservice.model.TypeVehicle;
import com.autoservice.service.RangeworksService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Legat on 10/21/2016.
 */
@RestController
@RequestMapping(value = "rangeworks")
public class RangeworksController {
    private final RangeworksService rangeworksService;

    public RangeworksController(RangeworksService rangeworksService) {
        this.rangeworksService = rangeworksService;
    }


    @RequestMapping(value = "/put", method = RequestMethod.PUT)
    public void create(@RequestBody Rangeworks rangework) {
        rangeworksService.create(rangework);
    }

    @RequestMapping(value = "/getbyid/{id}", method = RequestMethod.GET)
    public Rangeworks getById(@PathVariable("id") Long id) {

        return rangeworksService.get(id);
    }
    @RequestMapping(value = "/getall", method = RequestMethod.GET)
    public List<Rangeworks> getAll() {

        return rangeworksService.getAll();
    }

}
