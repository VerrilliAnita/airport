package it.uiip.airport.core.dao;



import java.util.List;

import it.uiip.airport.core.model.CabinCrewModel;


public interface CabinCrewDao {

	public CabinCrewModel findCabinCrewByCodeFiscal(String codeFiscal);
	public List<CabinCrewModel> findCabinCrewByMaxNumberOfRoutes();
	public List<CabinCrewModel> findAllCabinCrewes();
}
