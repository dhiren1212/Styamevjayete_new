package com.satyamevjayate.api.repo;

import java.math.BigInteger;

import org.springframework.data.jpa.repository.JpaRepository;

import com.satyamevjayate.api.dto.PoliceRequest;
import com.satyamevjayate.api.entity.Police;

public interface PoliceRepository extends JpaRepository<Police,BigInteger> {

	

}
