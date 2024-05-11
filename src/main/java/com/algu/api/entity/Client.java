package com.algu.api.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Data

@Entity  // Table
@Builder

public class Client {

    @Id    //primary key
    @GeneratedValue (strategy = GenerationType.AUTO)  // value for each attributes
    private Long clientID;

    //@Id // if it is a composite primary key
    private String clientName;

    private int clientAge;
    private String clientGender;

    
}
