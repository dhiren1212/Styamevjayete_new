package com.satyamevjayate.api.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "criminal")
public class Criminal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CriminalID")
    private Long criminalID;
    @Column(name = "PersonID")
    private Long PersonID;
    @Column(name = "ContactID")
    private Long ContactID;

    @Column(name="ResidenceAddressID")
    private Long criminalResidentAddressID;

    @Column(name="PermanentAddressID")
    private Long criminalPermanentAddress;
	
    @Column(name = "Height")
    private Long height;
    @Column(name = "Weight")
    private Long weight;
    @Column(name = "Type")
    private Long type;

}
