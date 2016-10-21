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


    @RequestMapping(value = "/ping", produces = MediaType.TEXT_PLAIN_VALUE)
    public String ping() {
        return "PONG-client";
    }


    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    public Client get(@PathVariable("id") Long id) {
        return clientService.get(id);
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Client> getAll() {
        return clientService.getAll();
    }

    @RequestMapping(value = "/mailbylid/{id}", method = RequestMethod.GET)
    public String mailbyid(@PathVariable("id") Long id) {
        return clientService.get(id).getEmail();
    }

    @RequestMapping(value = "/clientbymail/{mail:.+}", method = RequestMethod.GET)
    public List<Client> mailbyid(@PathVariable("mail") String mail) {
        return clientService.getClientByMail(mail);
    }

    @RequestMapping(value = "/chkclientdata/{mail:.+},{password}", method = RequestMethod.GET)
    public boolean chkClientData(@PathVariable("mail") String mail, @PathVariable("password") String password) {
        return clientService.ChkClientData(mail, password);

    }

    @RequestMapping(value = "/createclient/{name},{mail:.+},{password}", method = RequestMethod.PUT)
    public Client addClient(@PathVariable("mail") String name, @PathVariable("mail") String mail, @PathVariable("password") String password) {
        return clientService.create(new Client(name, mail, password));

    }

    @RequestMapping(value = "/deleteclient/{mail:.+}", method = RequestMethod.DELETE)
    public void deleteClient(@PathVariable("mail") String mail) {
        clientService.deleteByEmail(mail);
    }

    @RequestMapping(value = "/updatemailbyid/{id},{mail:.+}", method = RequestMethod.PUT)
    public Client updateEmailById(@PathVariable("id") Long id, @PathVariable("mail") String mail) {
        return clientService.updateEmailByID(id, mail);
    }

    @RequestMapping(value = "/put", method = RequestMethod.PUT)
    public void create() {
       Client client = new Client("Alx", "rr","pass");
        clientService.create(client);
    }

    @RequestMapping(value = "/updateavatarbyid/{id},{avatar}", method = RequestMethod.PATCH)
    public void updateAvatarById(@PathVariable("id") Long id, @PathVariable("avatar") String avatar) {
        clientService.updateAvatarByID(id, avatar);
    }

    @RequestMapping(value = "/updatepasswordbyid/{id},{avatar}", method = RequestMethod.PATCH)
    public void updatePasswordById(@PathVariable("id") Long id, @PathVariable("password") String password) {
        clientService.updatePasswordByID(id, password);
    }

    @RequestMapping(value = "/updateaddressbyid/", method = RequestMethod.PATCH)
    public void updateAddressById(@PathVariable("id") Long id) {
        Address address = new Address();
        clientService.updateAddressByID(id, address);

    }
}
