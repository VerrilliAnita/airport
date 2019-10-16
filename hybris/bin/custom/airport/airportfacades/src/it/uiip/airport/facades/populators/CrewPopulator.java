package it.uiip.airport.facades.populators;

import de.hybris.platform.converters.Populator;
import de.hybris.platform.servicelayer.dto.converter.ConversionException;
import de.hybris.platform.servicelayer.dto.converter.Converter;

import it.uiip.airport.core.model.CabinCrewModel;
import it.uiip.airport.core.model.CrewModel;
import it.uiip.airport.core.model.PilotModel;
import it.uiip.airport.facades.data.CabinCrewData;
import it.uiip.airport.facades.data.CrewData;
import it.uiip.airport.facades.data.PilotData;
import org.springframework.beans.factory.annotation.Required;

public class CrewPopulator implements Populator<CrewModel, CrewData> {

    private Converter<PilotModel, PilotData> pilotConverter;
    private Converter<CabinCrewModel, CabinCrewData> cabinCrewConverter;
    @Override
    public void populate(CrewModel source, CrewData target) throws ConversionException {
       target.setCodeCrew(source.getCodeCrew());
       target.setCabinCrew(cabinCrewConverter.convertAll(source.getCabinCrew()));
       target.setCommander(pilotConverter.convert(source.getCommander()));
       target.setPilotAide(pilotConverter.convert(source.getPilotAide()));

    }

    public Converter<PilotModel, PilotData> getPilotConverter() {
        return pilotConverter;
    }

    @Required
    public void setPilotConverter(Converter<PilotModel, PilotData> pilotConverter) {
        this.pilotConverter = pilotConverter;
    }

    public Converter<CabinCrewModel, CabinCrewData> getCabinCrewConverter() {
        return cabinCrewConverter;
    }
    @Required
    public void setCabinCrewConverter(Converter<CabinCrewModel, CabinCrewData> cabinCrewConverter) {
        this.cabinCrewConverter = cabinCrewConverter;
    }
}
