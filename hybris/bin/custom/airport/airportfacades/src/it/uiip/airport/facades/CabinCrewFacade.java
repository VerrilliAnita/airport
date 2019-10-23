package it.uiip.airport.facades;

import it.uiip.airport.facades.data.CabinCrewData;

import java.util.List;

public interface CabinCrewFacade {

    public CabinCrewData getCabinCrewForCodeFiscal(String codeFiscal);
    public List<CabinCrewData> getCabinCrewForMaxNumberOfRoutes();
    public List<CabinCrewData> getAllCabinCrewes();
}
