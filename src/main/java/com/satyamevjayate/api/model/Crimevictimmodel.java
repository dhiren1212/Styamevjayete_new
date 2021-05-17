package com.satyamevjayate.api.model;

import com.satyamevjayate.api.entity.CrimeVictim;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Crimevictimmodel {
        private String message;
        private List<CrimeVictim> crimeVictims;
}
