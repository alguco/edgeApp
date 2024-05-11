package com.algu.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.algu.api.entity.Client;
import com.algu.api.repository.ClientRepository;

import java.util.Objects;
import java.util.Optional;

@Service
public class ClientServiceImpl implements ClientService {

    @Autowired
    private ClientRepository clientRepository;
    
    //save
    @Override
    public Client saveClient(Client client) {
        
        return clientRepository.save (client);
    }

    // read
    @Override
    public List<Client> listClient() {
        
        return (List<Client>)clientRepository.findAll();
    }

    //update
    @Override
    public Client updateclient(Client client, Long clientID) {
        Client cliDB = clientRepository.findById(clientID).get();

        if(client == null){
            System.out.println("client not found");
            return null;
        }

        if (Objects.nonNull(client.getClientName()) && !"".equalsIgnoreCase(client.getClientName())) {
            cliDB.setClientName(client.getClientName());
            }
        
        if (Objects.nonNull(client.getClientAge())) {
                cliDB.setClientAge(client.getClientAge());
                }

        if (Objects.nonNull(client.getClientGender()) && !"".equalsIgnoreCase(client.getClientGender())) {
                    cliDB.setClientGender(client.getClientGender());
                    }

            return clientRepository.save(cliDB);
     }

    // delete
    @Override
    public void deleteClientID(Long ClientID) {
        clientRepository.deleteById(ClientID); 
    }

    //find
    @Override
    public Optional<Client> findById(Long id) {
        return clientRepository.findById(id);
    }
    
}
