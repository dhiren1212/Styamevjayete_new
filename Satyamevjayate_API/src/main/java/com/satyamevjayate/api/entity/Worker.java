package com.satyamevjayate.api.entity;

import lombok.*;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.math.BigInteger;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@Entity
@Table(name="worker")
public class Worker {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="WorkerID")
    private Long workerID;

    @Column(name="DateOfJoining")
    private Date dateOfJoining;

    @Column(name="DateOfResign")
    private Date dateOfResign;

    @Column(name="ResidenceAddressID")
    private Long workerResidentAddress;

    @Column(name="PermanentAddressID")
    private Long workerPermanentAddress;


    @Column( name = "ContactID")
    private Long contactId;
	
	@Column(name = "PersonID")
    private Long personId;

}
