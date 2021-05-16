package com.satyamevjayate.api.repo;

import java.math.BigInteger;

import org.springframework.data.jpa.repository.JpaRepository;

import com.satyamevjayate.api.entity.Contact;

public interface ContactRepository extends JpaRepository<Contact,Long> {

}
