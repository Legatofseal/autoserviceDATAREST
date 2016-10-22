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

//Create new Rangework
    @RequestMapping(value = "/put", method = RequestMethod.PUT)
    public void create(@RequestBody Rangeworks rangework) {
        rangeworksService.create(rangework);
    }

    //Get RangeWorks  by ID
    @RequestMapping(value = "/getbyid/{id}", method = RequestMethod.GET)
    public Rangeworks getById(@PathVariable("id") Long id) {

        return rangeworksService.get(id);
    }
    //get all rangeworks
    @RequestMapping(value = "/getall", method = RequestMethod.GET)
    public List<Rangeworks> getAll() {

        return rangeworksService.getAll();
    }
    //Add subworks from base to rangework by ID
    @RequestMapping(value = "/{idrw}/addsubw/{idsw}", method = RequestMethod.PUT)
    public void addSubwork(@PathVariable("idrw") Long idrw, @PathVariable("idveh") Long idsw) {

        rangeworksService.addSubwork(idrw, idsw);
    }
    //Delete subwork by ID from rangeworks by ID
    @RequestMapping(value = "/{idrw}/deletesubw/{idsw}", method = RequestMethod.PUT)
    public void  DeleteSubwork(@PathVariable("idrw") Long idrw, @PathVariable("idsw") Long idsw) {

        rangeworksService.remoSubwork(idrw, idsw);
    }


}
