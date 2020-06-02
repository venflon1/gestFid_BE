package com.xantrix.webapp.domain;

import java.io.Serializable;

import org.springframework.data.mongodb.core.mapping.Field;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cards implements Serializable{
	private static final long serialVersionUID = 4230529457060083755L;
	
	@Field(value = "bollini")
	private int bollini;
	
	@Field(value = "ultimaspesa")
	private String ultimaSpesa;
}
