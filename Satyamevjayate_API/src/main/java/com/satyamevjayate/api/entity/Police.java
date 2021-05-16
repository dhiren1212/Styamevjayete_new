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
	private Long	policeID;
	
	@Column(name="Pwd")
	private String pwd;
	
	@Column(name="PoliceCardImage")
	private Byte[] policeCardImage;

	@Column(name="ResidenceAddressID")
	private String policeResidentAddress;

	@Column(name="PermanentAddressID")
	private Addresses policePermanentAddress;
	
	@Column(name = "RoleID")
    private String roleId;
	
	@Column(name = "ContactID")
    private String contactId;
	
	@Column(name = "PersonID")
    private String personId;

	@Column(name = "PoliceStationID")
    private String policeStationId;
	

}
