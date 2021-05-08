package com.internet.base.application.controller;

import com.internet.base.application.model.Client;
import com.internet.base.application.service.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/api")
public class ClientController {


    private ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @PostMapping("/client")
    public Client addClient(@RequestBody Client client) {
        return clientService.addClient(client);

    }

//    @PostMapping
//    public int save(@RequestBody @Valid SaveUsersRequest request) {
//        return userService.save(request);
//    }

    @GetMapping("/client")
    public List<Client> getClients() {
        return clientService.getClients();

    }

    @GetMapping("/client/{clientId}")
    public ResponseEntity<?> getClientById(@PathVariable long clientId) {
        return clientService.getClientById(clientId);

    }

    @PutMapping("/client/{clientId}")
    public ResponseEntity<?> updateClient(@PathVariable long clientId, @Valid @RequestBody Client clientRequest) {

        return clientService.updateClient(clientId, clientRequest);
    }

    @DeleteMapping("/client/{clientId}")
    public ResponseEntity<?> deleteClient(@PathVariable long clientId) {

        return clientService.deleteClient(clientId);

    }

}
