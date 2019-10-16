package it.uiip.airport.facades;

import it.uiip.airport.facades.data.PilotData;

import java.util.List;

public interface PilotFacade {

    public PilotData getPilotForUid(String uid);
    public List<PilotData> getAllPilots();
}
