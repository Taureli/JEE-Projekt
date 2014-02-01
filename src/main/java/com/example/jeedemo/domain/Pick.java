package com.example.jeedemo.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.validation.constraints.Size;

@Entity
@NamedQuery(name ="pick.getAllPicks" , query = "Select p FROM Pick p ")
public class Pick {
	
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Size(min=2, max=20)
	private String nazwa;
	
	private double cena;
	@ManyToOne
	private Rozmiar rozmiar;
	@ManyToMany
	private List<Sklep> sklepy = new ArrayList<Sklep>();
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNazwa() {
		return nazwa;
	}
	public void setNazwa(String nazwa) {
		this.nazwa = nazwa;
	}
	public double getCena() {
		return cena;
	}
	public void setCena(double cena) {
		this.cena = cena;
	}
	public Rozmiar getRozmiar() {
		return rozmiar;
	}
	public void setRozmiar(Rozmiar rozmiar) {
		this.rozmiar = rozmiar;
	}
	public List<Sklep> getSklepy(){
		return sklepy;
	}
	public void setSklepy(List<Sklep> sklepy) {
		this.sklepy = sklepy;
	}
	
}
