package com.satyamevjayate.api.repo;

import com.satyamevjayate.api.entity.Criminal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CriminalRepository extends JpaRepository<Criminal,Long> {
}
