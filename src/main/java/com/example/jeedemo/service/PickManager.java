package com.example.jeedemo.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.example.jeedemo.domain.Pick;
import com.example.jeedemo.domain.Rozmiar;
import com.example.jeedemo.domain.Sklep;

@Stateless
public class PickManager {
	
	@PersistenceContext
	EntityManager em;
	
	public void addPick(Pick pick) {
		pick.setId(null);
		em.persist(pick);
	}
	
	public void addRozmiarToPick(Long pickId, Long rozmiarId){
		Pick pick = em.find(Pick.class, pickId);
		Rozmiar rozmiar = em.find(Rozmiar.class, rozmiarId);
		pick.setRozmiar(rozmiar);
	}
	
	public void addWlascicielToPickList(Long pickId, List<Sklep> tempList){
		Pick pick = em.find(Pick.class, pickId);
		for(Sklep w : tempList)
			pick.getSklepy().add(w);
	}
	

	public void addWlascicielToPick(Long pickId, List<Long> listaId){
		Pick pick = em.find(Pick.class, pickId);
		for(Long id : listaId){
			Sklep sklep = em.find(Sklep.class, id);
			pick.getSklepy().add(sklep);
		}
	}
	
	
	@SuppressWarnings("unchecked")
	public List<Pick> getAllPicks(){
		return em.createNamedQuery("pick.getAllPicks").getResultList();
	}

	public EntityManager getEm() {
		return em;
	}

	public void deletePick(Pick pick){
		pick = em.find(Pick.class, pick.getId());
		em.remove(pick);
	}
	
	public void editPick(Pick pick){
		em.merge(pick);
	}
	
}
