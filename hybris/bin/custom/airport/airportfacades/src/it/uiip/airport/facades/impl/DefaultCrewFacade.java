package it.uiip.airport.facades.impl;

import de.hybris.platform.servicelayer.dto.converter.Converter;
import it.uiip.airport.core.model.CrewModel;
import it.uiip.airport.core.model.RouteModel;
import it.uiip.airport.core.service.CrewService;
import it.uiip.airport.facades.CrewFacade;
import it.uiip.airport.facades.data.AirportRouteData;
import it.uiip.airport.facades.data.CrewData;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Required;

import java.util.List;

public class DefaultCrewFacade implements CrewFacade {

    private static final Logger LOG = Logger.getLogger(DefaultCrewFacade.class);

    private Converter<CrewModel, CrewData> crewConverter;

    private CrewService crewService;

    public CrewService getCrewService() {
        return crewService;
    }

    @Required
    public void setCrewService(CrewService crewService) {
        this.crewService = crewService;
    }

    public Converter<CrewModel, CrewData> getCrewConverter() {
        return crewConverter;
    }

    @Required
    public void setCrewConverter(Converter<CrewModel, CrewData> crewConverter) {
        this.crewConverter = crewConverter;
    }

    @Override
    public List<CrewData> getAllCrew() {
        LOG.info("Invoke method getAllCrew() in DefaultCrewFacade");
        return crewConverter.convertAll(crewService.getAllCrewes());
    }

    @Override
    public CrewData getCrewForCode(String codeCrew) {
        LOG.info("Invoke method getCrewForCode() in DefaultCrewFacade");
        return crewConverter.convert(crewService.getCrewForCode(codeCrew));
    }
}
