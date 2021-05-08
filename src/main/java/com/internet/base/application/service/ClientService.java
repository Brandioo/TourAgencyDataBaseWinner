package com.internet.base.application.service;

import com.internet.base.application.model.Client;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;


public interface ClientService {

    public Client addClient(Client client);

    public List<Client> getClients();

    public ResponseEntity<?> getClientById(long usersId);

    public ResponseEntity<?> updateClient(long usersId, Client userRequest);

    public ResponseEntity<?> deleteClient(long userId);

    long save(SaveClientsRequest request);

}
