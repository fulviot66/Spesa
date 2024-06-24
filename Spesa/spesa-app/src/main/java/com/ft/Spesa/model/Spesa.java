package com.ft.Spesa.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name = "ListaSpesa")
public class Spesa implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String articolo;
	private Boolean spunta;
	private Integer corsia;
	private Integer scaffale;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getArticolo() {
		return articolo;
	}
	public void setArticolo(String articolo) {
		this.articolo = articolo;
	}
	public Boolean getSpunta() {
		return spunta;
	}
	public void setSpunta(Boolean spunta) {
		this.spunta = spunta;
	}
	public Integer getCorsia() {
		return corsia;
	}
	public void setCorsia(Integer corsia) {
		this.corsia = corsia;
	}
	public Integer getScaffale() {
		return scaffale;
	}
	public void setScaffale(Integer scaffale) {
		this.scaffale = scaffale;
	}
	
}
