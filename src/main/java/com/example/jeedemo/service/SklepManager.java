package com.example.jeedemo.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.example.jeedemo.domain.Sklep;

@Stateless
public class SklepManager {

	@PersistenceContext
	EntityManager em;
	
	public void addSklep(Sklep sklep){
		sklep.setId(null);
		em.persist(sklep);
	}
	
	@SuppressWarnings("unchecked")
	public List<Sklep> getAllSklepy(){
		return em.createNamedQuery("sklep.getAll").getResultList();
	}
	
	public Sklep getSklepId(Long sklepId){
		return em.find(Sklep.class, sklepId);
	}
	
	public void deleteSklep(Sklep sklep){
		sklep = em.find(Sklep.class, sklep.getId());
		sklep.setDeleted(true);
	}
	
	public void edytujSklep(Sklep sklep){
		em.merge(sklep);
	}
}
