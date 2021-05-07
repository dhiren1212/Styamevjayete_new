package com.satyamevjayate.api.repo;

import java.math.BigInteger;

import org.springframework.data.jpa.repository.JpaRepository;

import com.satyamevjayate.api.entity.PoliceRole;



public interface PoliceRoleRepository extends JpaRepository<PoliceRole, BigInteger> {

}
