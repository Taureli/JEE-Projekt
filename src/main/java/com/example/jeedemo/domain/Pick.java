package com.example.jeedemo.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

@Entity
@NamedQuery(name ="pick.getAllPicks" , query = "Select p FROM Pick p ")
public class Pick {
	
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Size(min=2, max=20)
	private String nazwa;
	
	@Min(2)
	@Max(25)
	private double cena;
	@Temporal(TemporalType.DATE)
	private Date yop = new Date();
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
	
	
	@NotNull
	@Past
	public Date getYop() {
		return yop;
	}
	public void setYop(Date yop) {
		this.yop = yop;
	}
	
	@OneToMany(cascade=CascadeType.REMOVE) 
	public Rozmiar getRozmiar() {
		return rozmiar;
	}
	public void setRozmiar(Rozmiar rozmiar) {
		this.rozmiar = rozmiar;
	}
	
	@ManyToMany(cascade=CascadeType.REMOVE,fetch = FetchType.EAGER) 
	public List<Sklep> getSklepy(){
		return sklepy;
	}
	public void setSklepy(List<Sklep> sklepy) {
		this.sklepy = sklepy;
	}
	
}
