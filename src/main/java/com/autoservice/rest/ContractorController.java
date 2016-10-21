package com.autoservice.rest;

import com.autoservice.model.*;
import com.autoservice.service.ContractorService;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Legat on 10/16/2016.
 */
@RestController
@RequestMapping(value = "contractors")
public class ContractorController {
    private final ContractorService contractorService;

    public ContractorController(ContractorService contractorService) {
        this.contractorService = contractorService;
    }

    @RequestMapping(value = "put", method = RequestMethod.PUT)
    public void createContractor(@RequestBody Contractor contractor) {
        contractorService.create(contractor);
    }

    @RequestMapping(value = "/getbyid/{id}", method = RequestMethod.GET)
    public Contractor getById(@PathVariable("id") Long id) {

        return contractorService.get(id);
    }

    @RequestMapping(value = "/getbytypeservice/{id}", method = RequestMethod.GET)
    public List<Contractor> getByTypeOfService(@PathVariable("id") Long id) {

        return contractorService.getByTypeService(id);
    }

    @RequestMapping(value = "/getbyrangeworks/{id}", method = RequestMethod.GET)
    public List<Contractor> getByRangeworks(@PathVariable("id") Long id) {

        return contractorService.getByRangeworks(id);
    }

    @RequestMapping(value = "/getbycarmanuf/{id}", method = RequestMethod.GET)
    public List<Contractor> getByCarmanuf(@PathVariable("id") Long id) {

        return contractorService.getByCarmanuf(id);
    }

    @RequestMapping(value = "/getbyarea/{area}", method = RequestMethod.GET)
    public List<Contractor> getByArea(@PathVariable("area") String area) {

        return contractorService.getByArea(area);
    }

    @RequestMapping(value = "/getbyareaandcity/{area},{city}", method = RequestMethod.GET)
    public List<Contractor> getByAreaAndCity(@PathVariable("area") String area, @PathVariable("city") String city) {

        return contractorService.getByAreaAndCity(area, city);
    }

    @RequestMapping(value = "/getallrangework", method = RequestMethod.GET)
    public List<Rangeworks> getAllRange() {

        return contractorService.getAllRange();
    }


    @RequestMapping(value = "/updaddress", method = RequestMethod.PUT)
    public void addAddress(Long id, @RequestBody Address address) {

        contractorService.addAddress(1L, address);
    }

    @RequestMapping(value = "/addtypeservice/{id}", method = RequestMethod.PUT)
    public void addType(@PathVariable("id") Long id, @RequestBody TypeService typeService) {

        contractorService.addTypeService(id, typeService);
    }

    @RequestMapping(value = "/{idcon}/deletetypeservise/{idtpserv}", method = RequestMethod.PUT)
    public void addDeleteTypeService(@PathVariable("idcon") Long idcon, @PathVariable("idtpserv") Long idtpserv) {

        contractorService.removeTypeService(idcon, idtpserv);
    }

    @RequestMapping(value = "/{idcon}/addphone/{phone}", method = RequestMethod.PUT)
    public void addDeleteTypeService(@PathVariable("idcon") Long idcon, @PathVariable("phone") String phone) {
        Phone phone1 = new Phone(phone);
        contractorService.addPhone(idcon, phone1);
    }

    @RequestMapping(value = "/{idcon}/changeemail/{email:.+}", method = RequestMethod.PUT)
    public void updateEmail(@PathVariable("idcon") Long idcon, @PathVariable("email") String email) {

        contractorService.updateEmail(idcon, email);
    }

    @RequestMapping(value = "/{idcon}/deletephone/{idphone}", method = RequestMethod.PUT)
    public void deleteTypePhone(@PathVariable("idcon") Long idcon, @PathVariable("idphone") Long idphone) {

        contractorService.removePhone(idcon, idphone);
    }

    @RequestMapping(value = "/{idcon}/changefax/{fax}", method = RequestMethod.PUT)
    public void updateFax(@PathVariable("idcon") Long idcon, @PathVariable("fax") String fax) {

        contractorService.updateFax(idcon, fax);
    }

    @RequestMapping(value = "/{idcon}/changewdays/{workds}", method = RequestMethod.PUT)
    public void updateWorkingDays(@PathVariable("idcon") Long idcon, @PathVariable("workds") String workds) {

        contractorService.updateWorkingDays(idcon, workds);
    }

    @RequestMapping(value = "/{idcon}/changewhours/{workds}", method = RequestMethod.PUT)
    public void updateWorkingHours(@PathVariable("idcon") Long idcon, @PathVariable("workhrs") String workhrs) {

        contractorService.updateWorkingHours(idcon, workhrs);
    }

    @RequestMapping(value = "/addtypevehicle/{id}", method = RequestMethod.PUT)
    public void addTypeVehicle(@PathVariable("id") Long id, @RequestBody TypeVehicle typeVehicle) {

        contractorService.addTypeVehicle(id, typeVehicle);
    }
    @RequestMapping(value = "/{idcon}/deletetypevehicle/{idtpveh}", method = RequestMethod.PUT)
    public void addDeleteTypeVehicle(@PathVariable("idcon") Long idcon, @PathVariable("idtpveh") Long idtpveh) {

        contractorService.removeTypeVehicle(idcon, idtpveh);
    }



}
