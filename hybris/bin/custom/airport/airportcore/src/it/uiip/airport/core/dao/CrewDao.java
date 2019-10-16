package it.uiip.airport.core.dao;

import de.hybris.platform.servicelayer.internal.dao.GenericDao;
import it.uiip.airport.core.model.AirportModel;
import it.uiip.airport.core.model.CrewModel;

import java.util.List;

public interface CrewDao extends GenericDao<CrewModel> {

    public List<CrewModel> findAllCrewes();

    public CrewModel findCrewByCode(String codeCrew);

}
