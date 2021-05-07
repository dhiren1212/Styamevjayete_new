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
        private BigInteger crimeVictimID;

        @ManyToOne(optional=false)
        @JoinColumn(name = "AddressId")
        private Addresses addresses;

        @Column(name = "CrimeId")
        private Long CrimeID;
        
    	@ManyToOne(optional=false)
        @JoinColumn(name = "ContactId")
        private Contact contact;
    	
    	@ManyToOne(optional=false)
        @JoinColumn(name = "PersonID")
        private Person person;
        
    	
    	@OneToMany(mappedBy = "crimeVictimDocumentID")
        @JsonIgnore
        private List<CrimeVictimDocument> crimeVictimDocument;
    	
        @Column(name="Height")
        private Double height;
        @Column(name="Weight")
        private BigInteger weight;
}
