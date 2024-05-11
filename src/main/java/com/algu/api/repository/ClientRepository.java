package com.algu.api.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.algu.api.entity.Client;

@Repository
public interface ClientRepository extends CrudRepository <Client, Long>{  // <entity name, primary key variable type>
    
}
