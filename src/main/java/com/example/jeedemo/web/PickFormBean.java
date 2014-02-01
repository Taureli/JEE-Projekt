package com.example.jeedemo.web;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.model.ListDataModel;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.model.DualListModel;

import com.example.jeedemo.domain.Pick;
import com.example.jeedemo.domain.Rozmiar;
import com.example.jeedemo.domain.Sklep;
import com.example.jeedemo.service.PickManager;
import com.example.jeedemo.service.RozmiarManager;
import com.example.jeedemo.service.SklepManager;

@SessionScoped
@Named("pickBean")
public class PickFormBean implements Serializable {
	
	private Pick pick = new Pick();
	private ListDataModel<Pick> picks = new ListDataModel<Pick>();
	private DualListModel<Sklep> tempList; 
	private List<Sklep> sklepyTemp ;
	
	private Long pickId;
	private Long rozmiarId;
	private Long sklepId;
	
	@Inject
	PickManager pickManager;
	@Inject
	RozmiarManager rozmiarManager;
	@Inject
	SklepManager sklepManager;	

	
	public Pick getPick() {
		return pick;
	}
	
	public void setPick(Pick pick) {
		this.pick = pick;
	}

	// Actions
	public String addPick() {
		
		pickManager.addPick(pick);
		pickManager.addRozmiarToPick(pick.getId(), rozmiarId);		
		pickManager.addWlascicielToPickList(pick.getId(), sklepyTemp);

		return "showPicks";
	}
	
	public String deletePick(Pick pick){
		pickManager.deletePick(pick);
		return "showPicks";
	}

	public ListDataModel<Pick> getAllPicks() {
		picks.setWrappedData(pickManager.getAllPicks());
		return picks;
	}

	public Long getPickId() {
		return pickId;
	}

	public void sPickId(Long pickId) {
		this.pickId = pickId;
	}

	public Long getRozmiarId() {
		return rozmiarId;
	}

	public void setRozmiarId(Long rozmiarId) {
		this.rozmiarId = rozmiarId;
	}
	
	public List<Rozmiar> getAllRozmiary(){
		return rozmiarManager.getAllRozmiary();
	}

	public List<Sklep> getAllSklepy(){
		return sklepManager.getAllSklepy();
	}
	
	public Long getSklepId() {
		return sklepId;
	}

	public void setSklepId(Long sklepId) {
		this.sklepId = sklepId;
	}

	public DualListModel<Sklep> getTempList() {
		return (new DualListModel<Sklep>(sklepManager.getAllSklepy(), new ArrayList<Sklep>()));
	}

	public void setTempList(DualListModel<Sklep> tempList) {
		this.tempList = tempList;
	}

    public List<Sklep> getSelected() {
        return tempList.getTarget();
    }

	public List<Sklep> getSklepyTemp() {
		return sklepyTemp;
	}

	public void setSklepyTemp(List<Sklep> sklepyTemp) {
		this.sklepyTemp = sklepyTemp;
	}

	
	public String doEdycji(Pick pick){
		this.pick = pick;
		return "edytujPick";
	}
	
	public String editPick(){
		pickManager.editPick(pick);
		this.pick = new Pick();
		return "showPicks";
	}
	
}
