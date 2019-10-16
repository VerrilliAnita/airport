package it.uiip.airport.facades;

import it.uiip.airport.facades.data.CrewData;

import java.util.List;

public interface CrewFacade {

    public List<CrewData> getAllCrew();

    public CrewData getCrewForCode(String codeCrew);

}
