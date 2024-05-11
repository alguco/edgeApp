package com.algu.api.service;

import java.util.List;
import java.util.Optional;

import com.algu.api.entity.Client;

public interface ClientService {

    // save
    Client saveClient(Client client);
    
    // read 
    List<Client> listClient();

    //update
    Client updateclient (Client client,  Long clientID);

    // delete

    void deleteClientID (Long ClientID);

    //find
    Optional<Client> findById (Long id);
}
