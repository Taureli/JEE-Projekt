package com.example.jeedemo.web;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.faces.model.ListDataModel;
import javax.faces.model.SelectItem;
import javax.inject.Inject;
import javax.inject.Named;

import com.example.jeedemo.domain.Rozmiar;
import com.example.jeedemo.domain.Sklep;
import com.example.jeedemo.service.RozmiarManager;

@SessionScoped
@Named("rozmiarBean")
public class RozmiarFormBean implements Serializable{

	private Rozmiar rozmiar = new Rozmiar();
//	private ListDataModel<Rozmiar> rozmiary = new ListDataModel<Rozmiar>();
//	private List<SelectItem> lista = new ArrayList<SelectItem>();
	
	@Inject
	RozmiarManager rozmiarManager;
	
	public Rozmiar getRozmiar() {
		return rozmiar;
	}
	
	public void setRozmiar(Rozmiar rozmiar) {
		this.rozmiar = rozmiar;
	}
	
	public String addRozmiar(){
		rozmiarManager.addRozmiar(rozmiar);
		return "showRozmiary";
	}
	
	
	public List<Rozmiar> getAllRozmiary(){
		return rozmiarManager.getAllRozmiary();
	}
	
	
	public String deleteRozmiar(Rozmiar rozmiar){
		rozmiarManager.deleteRozmiar(rozmiar);
		return "showRozmiary";
	}
	
	public String doEdycji(Rozmiar rozmiar){
		this.rozmiar = rozmiar;
		return "edytujRozmiar";
	}
	
	public String edytujRozmiar(){
		rozmiarManager.edytujRozmiar(rozmiar);
		this.rozmiar = new Rozmiar();
		return "showRozmiary";
	}
	
}
