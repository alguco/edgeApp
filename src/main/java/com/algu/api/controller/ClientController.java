package com.algu.api.controller;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.algu.api.entity.Client;
import com.algu.api.service.ClientService;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/client")

public class ClientController {

    //no-args Constructor 
    public ClientController(){
    }

    @Autowired
    private ClientService clientService;  

     List<Client> clientList = new ArrayList<Client>();
    

    // save method
    @PostMapping ("/clients")
    public String saveClient(@Valid @RequestBody Client client){
         clientService.saveClient(client);
         return "Data added successfully";
    }

    //Read method
    @GetMapping ("/clients")
        public List<Client> listClient(){
            return clientService.listClient();
        } 

        //update method
        @PutMapping ("/clients/{id}")
        public String updateClient(@RequestBody Client client, @PathVariable("id") Long inputedID){
            if(clientService.findById(inputedID).isPresent()) {
                clientService.updateclient(client, inputedID);
                return "Client data was updated successfully";
            }
            return "client id "+inputedID+" was not found";
        }

        //delete method
        @DeleteMapping ("/clients/{id}")
        public String deleteClient(@PathVariable("id") Long id){
            if(clientService.findById(id).isPresent()) {
                clientService.deleteClientID(id);
            return "client data was deleted successfully";
            }
            return "client id "+id+" was not found";
        }
}

