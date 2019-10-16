package it.uiip.airport.core.service;

import it.uiip.airport.core.model.AirportModel;
import it.uiip.airport.core.model.CrewModel;

import java.util.List;

public interface CrewService {

    public List<CrewModel> getAllCrewes();

    public CrewModel getCrewForCode(String codeCrew);

}
