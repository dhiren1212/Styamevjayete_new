package com.satyamevjayate.api.entity;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigInteger;
import java.util.Date;
import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name="Crime")
public class Crime {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="CrimeID")
    private Long crimeID;
    
    @Column(name="CrimeDate")
    private Date crimeDate;

    @Column(name="CrimeTime")
    private Date crimeTime;

    @Column(name="Description")
    private String description;

    @Column(name = "AddressID")
    private Long  AddressID;

    @Column(name="CrimeTypeID")
    private Long CrimeTypeID;

}
