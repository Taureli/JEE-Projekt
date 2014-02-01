package com.example.jeedemo.web;import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.faces.model.ListDataModel;
import javax.inject.Inject;
import javax.inject.Named;

import com.example.jeedemo.domain.Sklep;
import com.example.jeedemo.service.SklepManager;

@SessionScoped
@Named("sklepBean")
public class SklepFormBean implements Serializable{

	private Sklep sklep = new Sklep();
	private ListDataModel<Sklep> sklepy = new ListDataModel<Sklep>();
	private Long sklepId;
	
	@Inject
	SklepManager sklepManager;
	
	// Actions
	public String addSklep() {
		sklepManager.addSklep(sklep);
		return "showSklepy";
	}
	
	public Sklep getSklep(){
		return sklep;
	}
	
	public void setSklep(Sklep sklep){
		this.sklep = sklep;
	}
	
	public ListDataModel<Sklep> getAllSklepy(){
		sklepy.setWrappedData(sklepManager.getAllSklepy());
		return sklepy;
	}

	public Long getSklepId() {
		return sklepId;
	}

	public void setSklepId(Long sklepId) {
		this.sklepId = sklepId;
	}
	
	public String deleteSklep(Sklep sklep){
		sklepManager.deleteSklep(sklep);
		return "showSklepy";
	}
	
	public String doEdycji(Sklep sklep){
		this.sklep = sklep;
		return "edytujSklep";
	}
	
	public String edytujSklep(){
		sklepManager.edytujSklep(sklep);
		this.sklep = new Sklep();
		return "showSklepy";
	}
}
