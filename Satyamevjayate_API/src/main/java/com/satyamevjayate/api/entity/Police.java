package com.satyamevjayate.api.entity;

import java.math.BigInteger;
import java.util.List;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name="police")
public class Police {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="PoliceID")
	private BigInteger	policeID;
	
	@Column(name="Pwd")
	private String pwd;
	
	@Column(name="PoliceCardImage")
	private Byte[] policeCardImage;

	@OneToOne(optional=false)
	@JoinColumn(name="ResidenceAddressID", referencedColumnName = "AddressID",insertable = false,updatable = false)
	private Addresses policeResidentAddress;

	@OneToOne(optional=false)
	@JoinColumn(name="PermanentAddressID",referencedColumnName = "AddressID",insertable = false,updatable = false)
	private Addresses policePermanentAddress;
	
	@ManyToOne(optional=false)
    @JoinColumn(name = "RoleID")
    private PoliceRole policeRole;
	
	@ManyToOne(optional=false)
    @JoinColumn(name = "ContactId")
    private Contact policeContact;
	
	@ManyToOne(optional=false)
    @JoinColumn(name = "PersonID")
    private Person person;
	
	
	@ManyToOne(optional=false)
    @JoinColumn(name = "PoliceStationID")
    private PoliceStation policeStation;
	

}
