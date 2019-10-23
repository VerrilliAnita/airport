package it.uiip.airport.facades.impl;

import de.hybris.platform.servicelayer.dto.converter.Converter;
import it.uiip.airport.core.model.PilotModel;
import it.uiip.airport.core.service.PilotService;
import it.uiip.airport.facades.PilotFacade;
import it.uiip.airport.facades.data.PilotData;
import org.springframework.beans.factory.annotation.Required;

import java.util.List;

public class DefaultPilotFacade implements PilotFacade {

    private PilotService pilotService;
    private Converter<PilotModel, PilotData> pilotConverter;
    @Override
    public PilotData getPilotForUid(String uid) {
        return pilotConverter.convert(pilotService.getPilotForUid(uid));
    }

    @Override
    public List<PilotData> getAllPilots() {
        return pilotConverter.convertAll(pilotService.getAllPilots());
    }


    @Required
    public void setPilotService(PilotService pilotService) {
        this.pilotService = pilotService;
    }

    @Required
    public void setPilotConverter(Converter<PilotModel, PilotData> pilotConverter) {
        this.pilotConverter = pilotConverter;
    }
}
