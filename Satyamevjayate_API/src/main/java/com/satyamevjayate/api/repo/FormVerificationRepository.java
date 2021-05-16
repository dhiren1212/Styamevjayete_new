package com.satyamevjayate.api.repo;

import com.satyamevjayate.api.entity.Formverification;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigInteger;

public interface FormVerificationRepository extends JpaRepository<Formverification, Long> {
}
