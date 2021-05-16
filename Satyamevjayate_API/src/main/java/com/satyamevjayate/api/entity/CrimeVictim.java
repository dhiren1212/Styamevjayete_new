package com.satyamevjayate.api.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.math.BigInteger;
import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="CrimeVictim")
public class CrimeVictim {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name="CrimeVictimID")
        private Long crimeVictimID;

        @Column(name = "CrimeId")
        private Long crimeID;
        
    	@Column(name = "ContactID")
        private Long contactId;
    	
    	@Column(name = "PersonID")
        private Long personId;

        @Column(name = "ResidenceAddressID")
        private Long ResidenceAddressID;

        @Column(name = "PermanentAddressID")
        private Long PermanentAddressID;

        @Column(name="Height")
        private Double height;

        @Column(name="Weight")
        private Double weight;
}
