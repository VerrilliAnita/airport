package it.uiip.airport.core.service;

import java.util.List;

import it.uiip.airport.core.model.CabinCrewModel;

public interface CabinCrewService {
	
	public List<CabinCrewModel> getCabinCrewForMaxNumberOfRoutes();
	public List<CabinCrewModel> getAllCabinCrewes();

}
