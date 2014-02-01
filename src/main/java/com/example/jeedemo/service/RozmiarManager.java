package com.example.jeedemo.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.example.jeedemo.domain.Rozmiar;

@Stateless
public class RozmiarManager {

	@PersistenceContext
	EntityManager em;
	
	public void addRozmiar(Rozmiar rozmiar){
		rozmiar.setId(null);
		em.persist(rozmiar);
	}
	
	public List<Rozmiar> getAllRozmiary(){
		return em.createNamedQuery("rozmiar.getRozmiary").getResultList();
	}
	
	public void deleteRozmiar(Rozmiar rozmiar){
		rozmiar = em.find(Rozmiar.class, rozmiar.getId());
		rozmiar.setDeleted(true);
		//em.remove(rozmiar);
	}
	
	public void edytujRozmiar(Rozmiar rozmiar){
		em.merge(rozmiar);
	}
}
