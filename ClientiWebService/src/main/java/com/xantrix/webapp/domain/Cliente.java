package com.xantrix.webapp.domain;

import java.io.Serializable;
import java.sql.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Document // uguale alla annotation @Entity ma per db NOSQL
@Data	// mi crea i metodi get e set per ogni variabile di istanza
@AllArgsConstructor // mi crea costruttore con tutti gli args quanti sono le variabili di istanza
@NoArgsConstructor // mi crea costruttore vuoto
public class Cliente implements Serializable{
	private static final long serialVersionUID = 4390776294026206924L;	
	
	@Id
	private String id;
	
	@Field(value = "codfid")		// stessa annotazione di @Column ma per ddb NOSQL
	private String codFid;
	
	@Field(value = "nominativo") 	// stessa annotazione di @Column ma per ddb NOSQL
	private String nominativo;
	
	@Field(value = "indirizzo")		// stessa annotazione di @Column ma per ddb NOSQL
	private String indirizzo;
	
	@Field(value = "comune")		// stessa annotazione di @Column ma per ddb NOSQL
	private String comune;
	
	@Field(value = "cap")			// stessa annotazione di @Column ma per ddb NOSQL
	private String cap;
	
	@Field(value = "prov")			// stessa annotazione di @Column ma per ddb NOSQL
	private String provincia;
	
	@Field(value = "telefono")		// stessa annotazione di @Column ma per ddb NOSQL
	private String telefono;
	
	@Field(value = "mail")			// stessa annotazione di @Column ma per ddb NOSQL
	private String mail;	
	
	@Field(value = "attivo")		// stessa annotazione di @Column ma per ddb NOSQL
	private boolean attivo;
	
	@Field(value = "datacreazione")	// stessa annotazione di @Column ma per ddb NOSQL
	private Date dataCreazione;
	
	@Field(value = "cards")			// stessa annotazione di @Column ma per ddb NOSQL
	private Cards cards;
}
