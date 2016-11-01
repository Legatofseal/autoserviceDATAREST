package com.autoservice.rest;

import com.autoservice.model.*;
import com.autoservice.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Legat on 9/28/2016.
 */
@RestController
@RequestMapping(value = "clients")
public class ClientController {
    private final ClientService clientService;

    @Autowired
    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

//For testing purposes
    @RequestMapping(value = "/ping", produces = MediaType.TEXT_PLAIN_VALUE)
    public String ping() {
        return "PONG-client";
    }

// Get Client by by ID
    @RequestMapping(value = "/byid/{id}", method = RequestMethod.GET)
    public Client get(@PathVariable("id") Long id) {
        return clientService.get(id);
    }

    // Get All Clients
    @RequestMapping(method = RequestMethod.GET)
    public List<Client> getAll() {
        return clientService.getAll();
    }

    //Get mail by clients ID
    @RequestMapping(value = "/mailbylid/{id}", method = RequestMethod.GET)
    public String mailbyid(@PathVariable("id") Long id) {
        return clientService.get(id).getEmail();
    }


    //get client by email
    @RequestMapping(value = "/clientbymail/{mail:.+}", method = RequestMethod.GET)
    public Client mailbyid(@PathVariable("mail") String mail) {
        return clientService.getClientByMail(mail);
    }

    //get client by email
    @RequestMapping(value = "/login/", method = RequestMethod.POST)
    public AuthClnt mailbyid(@RequestParam("email") String email, @RequestParam("password") String password) {
        Client temp = clientService.getClientByMail(email);
        if (!temp.equals(null)){
            if (temp.getPassword().equals(password)){
                return  new AuthClnt(temp.getId(),temp.getName(),true);
            }
            else {
                return new AuthClnt();
            }
        }
        else {
            return  new AuthClnt();
        }
    }

    //check client data
    @RequestMapping(value = "/chkclientdata/{mail:.+},{password}", method = RequestMethod.GET)
    public boolean chkClientData(@PathVariable("mail") String mail, @PathVariable("password") String password) {
        return clientService.ChkClientData(mail, password);

    }

    //Create client by name, password, mail
    @RequestMapping(value = "/createclient/{name},{mail:.+},{password}", method = RequestMethod.PUT)
    public Client addClient(@PathVariable("mail") String name, @PathVariable("mail") String mail, @PathVariable("password") String password) {
        return clientService.create(new Client(name, mail, password));

    }

    //Delete client by ID
    @RequestMapping(value = "/deleteclient/{mail:.+}", method = RequestMethod.DELETE)
    public void deleteClient(@PathVariable("mail") String mail) {
        clientService.deleteByEmail(mail);
    }

    //Change email in client
    @RequestMapping(value = "/{id}/updatemailbyid/{mail:.+}", method = RequestMethod.PUT)
    public Client updateEmailById(@PathVariable("id") Long id, @PathVariable("mail") String mail) {
        return clientService.updateEmailByID(id, mail);
    }
// Creation client for testing purposes
    @RequestMapping(value = "/put", method = RequestMethod.PUT)
    public void create() {
       Client client = new Client("Alx", "rr","pass");
        clientService.create(client);
    }
// Update avatar string in client
    @RequestMapping(value = "/{id}/updateavatarbyid/{avatar}", method = RequestMethod.PATCH)
    public void updateAvatarById(@PathVariable("id") Long id, @PathVariable("avatar") String avatar) {
        clientService.updateAvatarByID(id, avatar);
    }

//Update password in client
    @RequestMapping(value = "/{id}/updatepasswordbyid/{password}", method = RequestMethod.PATCH)
    public void updatePasswordById(@PathVariable("id") Long id, @PathVariable("password") String password) {
        clientService.updatePasswordByID(id, password);
    }

    // Update address by id in client
    @RequestMapping(value = "/updateaddressbyid/{id}", method = RequestMethod.PATCH)
    public void updateAddressById(@PathVariable("id") Long id, @RequestBody Address address) {
        //
        clientService.updateAddressByID(id, address);

    }
//Add vehicle from base to client
    @RequestMapping(value = "/{idcl}/addvehicle/{idveh}", method = RequestMethod.PUT)
    public void addVehicle(@PathVariable("idcon") Long idcl, @PathVariable("idveh") Long idveh) {

        clientService.addVehicle(idcl, idveh);
    }
//Delete vehicle in client
    @RequestMapping(value = "/{idcon}/deletevehicle/{idveh}", method = RequestMethod.PUT)
    public void  DeleteTypeService(@PathVariable("idcon") Long idcon, @PathVariable("idveh") Long idveh) {

        clientService.remoVehicle(idcon, idveh);
    }
}
