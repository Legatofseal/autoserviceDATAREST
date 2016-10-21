package com.autoservice.rest;

import com.autoservice.model.TypeService;
import com.autoservice.model.TypeVehicle;
import com.autoservice.service.TypeServiceService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Legat on 10/21/2016.
 */
@RestController
@RequestMapping(value = "typeservice")
public class TypeServiceController {

    private final TypeServiceService typeServiceService;

    public TypeServiceController(TypeServiceService typeServiceService) {
        this.typeServiceService = typeServiceService;
    }


    @RequestMapping(value = "/put", method = RequestMethod.PUT)
    public void create(@RequestBody TypeService typeService) {
        typeServiceService.create(typeService);
    }

    @RequestMapping(value = "/getbyid/{id}", method = RequestMethod.GET)
    public TypeService getById(@PathVariable("id") Long id) {

        return typeServiceService.get(id);
    }
    @RequestMapping(value = "/getall", method = RequestMethod.GET)
    public List<TypeService> getAll() {

        return typeServiceService.getAll();
    }
}
