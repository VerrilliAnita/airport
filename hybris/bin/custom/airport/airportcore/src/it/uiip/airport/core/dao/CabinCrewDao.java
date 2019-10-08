package it.uiip.airport.core.dao;



import java.util.List;

import it.uiip.airport.core.model.CabinCrewModel;


public interface CabinCrewDao {
	
	public List<CabinCrewModel> findCabinCrewByMaxNumberOfRoutes();
	
	public List<CabinCrewModel> findAllCabinCrewes();
}
