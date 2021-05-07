package com.satyamevjayate.api.model;

import com.satyamevjayate.api.entity.Police;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class policeModel {
	
	 private String message;
	 private List<Police> police;

}
