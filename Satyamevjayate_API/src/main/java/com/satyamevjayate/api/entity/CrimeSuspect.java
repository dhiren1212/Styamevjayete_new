package com.satyamevjayate.api.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.math.BigInteger;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="CrimeSuspect")
public class CrimeSuspect {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="CrimeSuspectID")
    private Long crimeSuspectID;

    @Column(name = "ResidenceAddressID")
    private Long ResidenceAddressID;

    @Column(name = "PermanentAddressID")
    private Long PermanentAddressID;

    @Column(name="CrimeID")
    private Long CrimeId;
    
	@Column(name = "ContactId")
    private Long ContactID;
	
	@Column(name = "PersonID")
    private Long PersonID;

}
