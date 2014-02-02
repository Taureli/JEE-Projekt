package com.example.jeedemo.web;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;

import com.example.jeedemo.domain.Sklep;
import com.example.jeedemo.service.PickManager;
import com.example.jeedemo.service.SklepManager;

@FacesConverter(forClass = Sklep.class, value="listaConverter")
public class ListConverter implements Converter {
	
	@Inject
	PickFormBean pb;
	@Inject 
	SklepManager sklepManager;
	@Inject
	PickManager pickManager;
	
	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		if(value == null){
			return null;
		}
		return pickManager.getEm().find(Sklep.class, Long.valueOf(value));
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if(value == null){
			return "";
		}
		if(value instanceof Sklep){
			return String.valueOf(((Sklep) value).getId());
		}
		return "";
	}

}
