package it.uiip.airport.core.service;

import de.hybris.platform.servicelayer.user.UserService;
import it.uiip.airport.core.model.PilotModel;

import java.util.List;

public interface PilotService extends UserService {

    public PilotModel getPilotForUid(String uid);
    public List<PilotModel> getAllPilots();
}
