package it.uiip.airport.core.service.impl;

import it.uiip.airport.core.dao.CrewDao;
import it.uiip.airport.core.model.CrewModel;
import it.uiip.airport.core.service.CrewService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Required;

import java.util.List;

public class DefaultCrewService implements CrewService {

    private static final Logger LOG = Logger.getLogger(DefaultAirportService.class);
    private CrewDao crewDao;

    public CrewDao getCrewDao() {
        return crewDao;
    }

    @Required
    public void setCrewDao(CrewDao crewDao) {
        this.crewDao = crewDao;
    }

    @Override
    public List<CrewModel> getAllCrewes() {
        return crewDao.findAllCrewes();
    }

    @Override
    public CrewModel getCrewForCode(String codeCrew) {
        return crewDao.findCrewByCode(codeCrew);
    }
}
