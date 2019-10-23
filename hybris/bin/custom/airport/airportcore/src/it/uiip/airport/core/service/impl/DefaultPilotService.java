package it.uiip.airport.core.service.impl;

import de.hybris.platform.servicelayer.user.impl.DefaultUserService;
import it.uiip.airport.core.dao.PilotDao;
import it.uiip.airport.core.model.PilotModel;
import it.uiip.airport.core.service.PilotService;

import java.util.List;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Required;


public class DefaultPilotService extends DefaultUserService implements PilotService {

    private static final Logger LOG = Logger.getLogger(DefaultAirportService.class);
    private PilotDao pilotDao;

    @Override
    public PilotModel getPilotForUid(String uid) {

        LOG.info("Invoke method findPilotByUid in DefaultPilotService");
        return pilotDao.findPilotByUid(uid);
    }

    @Override
    public List<PilotModel> getAllPilots() {
        LOG.info("Invoke method findAllPilots in DefaultPilotService");
        return pilotDao.findAllPilots();
    }

    public PilotDao getPilotDao() {
        return pilotDao;
    }

    @Required
    public void setPilotDao(PilotDao pilotDao) {
        this.pilotDao = pilotDao;
    }
}
