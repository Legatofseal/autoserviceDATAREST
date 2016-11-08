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

    //get contractor by email
    @RequestMapping(value = "/getbyemail/{email}", method = RequestMethod.GET)
    public Contractor getByEmail(@PathVariable("email") String email) {

        return contractorService.getByEmail(email);
    }

    // get list of contractors by typeVehicle
    @RequestMapping(value = "/getbytypevehicle/{id}", method = RequestMethod.GET)
    public List<Contractor> getByTypeOfVehicle(@PathVariable("id") Long id) {

        return contractorService.getByTypeVehicle(id);
    }

    // get list of contractors by typeService
    @RequestMapping(value = "/getbytypeservice/{id}", method = RequestMethod.GET)
    public List<Contractor> getByTypeOfService(@PathVariable("id") Long id) {

        return contractorService.getByTypeService(id);
    }


//// get list of contractors by Rangeworks
    @RequestMapping(value = "/getbyrangeworks/{id}", method = RequestMethod.GET)
    public List<Contractor> getByRangeworks(@PathVariable("id") Long id) {

        return contractorService.getByRangeworks(id);
    }

//get contractor by ID
    @RequestMapping(value = "/getbyid/{id}", method = RequestMethod.GET)
    public Contractor getById(@PathVariable("id") Long id) {

        return contractorService.get(id);
    }

    //// get list of contractors by Carmanufacture
    @RequestMapping(value = "/getbycarmanuf/{id}", method = RequestMethod.GET)
    public List<Contractor> getByCarmanuf(@PathVariable("id") Long id) {

        return contractorService.getByCarmanuf(id);
    }

    ////// get list of contractors by Area
    @RequestMapping(value = "/getbyarea/{area}", method = RequestMethod.GET)
    public List<Contractor> getByArea(@PathVariable("area") String area) {

        return contractorService.getByArea(area);
    }

    //// get list of contractors by Area and City

    @RequestMapping(value = "/getbyareaandcity/{area},{city}", method = RequestMethod.GET)
    public List<Contractor> getByAreaAndCity(@PathVariable("area") String area, @PathVariable("city") String city) {

        return contractorService.getByAreaAndCity(area, city);
    }


    //Creation of Contractor
    @RequestMapping(value = "/put", method = RequestMethod.PUT)
    public void createContractor(@RequestBody Contractor contractor) {
        contractorService.create(contractor);
    }




    // delete contractor by ID
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.PUT)
    public void deleteContractor(@PathVariable("id") Long id) {
        contractorService.delete(id);
    }


    //add typeservice for contractor (from db)
    @RequestMapping(value = "/{idcon}/addtypeservice/{idtpserv}", method = RequestMethod.PUT)
    public void addTypeService(@PathVariable("idcon") Long idcon, @PathVariable("idtpserv") Long idtpserv) {

        contractorService.addTypeService(idcon, idtpserv);
    }
// delete typeservice from contractor
    @RequestMapping(value = "/{idcon}/deletetypeservise/{idtpserv}", method = RequestMethod.PUT)
    public void  DeleteTypeService(@PathVariable("idcon") Long idcon, @PathVariable("idtpserv") Long idtpserv) {

        contractorService.removeTypeService(idcon, idtpserv);
    }

    //Change email in contractor

    @RequestMapping(value = "/{idcon}/changeemail/{email:.+}", method = RequestMethod.PUT)
    public void updateEmail(@PathVariable("idcon") Long idcon, @PathVariable("email") String email) {

        contractorService.updateEmail(idcon, email);
    }
    //Add Phone to contractor, create Phone object from string

    @RequestMapping(value = "/{idcon}/addphone/{phone}", method = RequestMethod.PUT)
    public void addPhone(@PathVariable("idcon") Long idcon, @PathVariable("phone") String phone) {
        Phone phone1 = new Phone(phone);
        contractorService.addPhone(idcon, phone1);
    }

    // delete phone from contractor
    @RequestMapping(value = "/{idcon}/deletephone/{idphone}", method = RequestMethod.PUT)
    public void deletePhone(@PathVariable("idcon") Long idcon, @PathVariable("idphone") Long idphone) {

        contractorService.removePhone(idcon, idphone);
    }

    //Change fax in Contractor
    @RequestMapping(value = "/{idcon}/changefax/{fax}", method = RequestMethod.PUT)
    public void updateFax(@PathVariable("idcon") Long idcon, @PathVariable("fax") String fax) {

        contractorService.updateFax(idcon, fax);
    }

    //Change WorkingDays in Contractor
    @RequestMapping(value = "/{idcon}/changewdays/{workds}", method = RequestMethod.PUT)
    public void updateWorkingDays(@PathVariable("idcon") Long idcon, @PathVariable("workds") String workds) {

        contractorService.updateWorkingDays(idcon, workds);
    }
//Change WorkingHours in Contractor
    @RequestMapping(value = "/{idcon}/changewhours/{workds}", method = RequestMethod.PUT)
    public void updateWorkingHours(@PathVariable("idcon") Long idcon, @PathVariable("workhrs") String workhrs) {

        contractorService.updateWorkingHours(idcon, workhrs);
    }

    //Update Address in Contractor

    @RequestMapping(value = "/updaddress", method = RequestMethod.PUT)
    public void addAddress(Long id, @RequestBody Address address) {

        contractorService.addAddress(1L, address);
    }

    //Add typeVehicle to Contractor (from db)
    @RequestMapping(value = "/{idcon}/addtypevehicle/{idtpveh}", method = RequestMethod.PUT)
    public void addTypeVehicle(@PathVariable("idcon") Long idcon, @PathVariable("idtpveh") Long idtpveh) {

        contractorService.addTypeVehicle(idcon, idtpveh);
    }

    //Delete typeVehicle from Contractor
    @RequestMapping(value = "/{idcon}/deletetypevehicle/{idtpveh}", method = RequestMethod.PUT)
    public void DeleteTypeVehicle(@PathVariable("idcon") Long idcon, @PathVariable("idtpveh") Long idtpveh) {

        contractorService.removeTypeVehicle(idcon, idtpveh);
    }

//Add Rangeworks to Contractor  (from db)
    @RequestMapping(value = "/{idcon}/addrangework/{idrangew}", method = RequestMethod.PUT)
    public void addRangework(@PathVariable("idcon") Long idcon, @PathVariable("idtpveh") Long idrangew) {

        contractorService.addRangeworks(idcon, idrangew);
    }

    //Delete rangeworks from Contractor
    @RequestMapping(value = "/{idcon}/deleterangework/{idrangew}", method = RequestMethod.PUT)
    public void DeleteRangework(@PathVariable("idcon") Long idcon, @PathVariable("idtpveh") Long idrangew) {

        contractorService.removeRangework(idcon, idrangew);
    }

    //Add Carmanifacture to Contractor (from DB)

    @RequestMapping(value = "/{idcon}/addcarmanuf/{idcarmanuf}", method = RequestMethod.PUT)
    public void addCarmanuf(@PathVariable("idcon") Long idcon, @PathVariable("idcarmanuf") Long idcarmanuf) {

        contractorService.addCarmanuf(idcon, idcarmanuf);
    }

    //Delete Carmanufacture from Contractor

    @RequestMapping(value = "/{idcon}/deletecarmanuf/{idcarmanuf}", method = RequestMethod.PUT)
    public void DeleteCarmanuf(@PathVariable("idcon") Long idcon, @PathVariable("idcarmanuf") Long idcarmanuf) {

        contractorService.removeCarmanuf(idcon, idcarmanuf);
    }

    //Change URL in Contractor
    @RequestMapping(value = "/{idcon}/changeurl{url}", method = RequestMethod.PUT)
    public void updateUrl(@PathVariable("idcon") Long idcon, @PathVariable("url") String url) {

        contractorService.updateUrl(idcon, url);
    }

    //Change avatar string in Contractor
    @RequestMapping(value = "/{idcon}/changeavatar/{avatar}", method = RequestMethod.PUT)
    public void updateAvatar(@PathVariable("idcon") Long idcon, @PathVariable("avatar") String avatar) {

        contractorService.updateAvatar(idcon, avatar);
    }



}
