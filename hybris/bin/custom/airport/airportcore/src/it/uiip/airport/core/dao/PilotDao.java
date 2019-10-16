package it.uiip.airport.core.dao;

import de.hybris.platform.servicelayer.internal.dao.GenericDao;
import it.uiip.airport.core.model.PilotModel;

import java.util.List;

public interface PilotDao extends GenericDao<PilotModel> {

    public PilotModel findPilotByUid(String uid);
    public List<PilotModel> findAllPilots();
}
