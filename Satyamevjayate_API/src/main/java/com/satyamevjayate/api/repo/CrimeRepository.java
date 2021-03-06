package com.satyamevjayate.api.repo;

import com.satyamevjayate.api.entity.Crime;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigInteger;

public interface CrimeRepository extends JpaRepository<Crime, Long> {
}
