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
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Required;

public class CrewPopulator  implements Populator<CrewModel, CrewData> {

    private static final Logger LOG = Logger.getLogger(CrewPopulator.class);

    private Converter<PilotModel, PilotData> pilotConverter;
    private Converter<CabinCrewModel, CabinCrewData> cabinCrewConverter;

    @Override
    public void populate(CrewModel source, CrewData target) throws ConversionException {
        LOG.info("Invoke method populate() in CrewPopulator");

        if(source.getCodeCrew() != null)
        {
            target.setCodeCrew(source.getCodeCrew());
        }
        if(source.getCabinCrew() != null)
        {
            target.setCabinCrew(cabinCrewConverter.convertAll(source.getCabinCrew()));
        }
        if(source.getCommander() != null)
        {
            target.setCommander(pilotConverter.convert(source.getCommander()));
        }
        if(source.getPilotAide() != null)
        {
            target.setPilotAide(pilotConverter.convert(source.getPilotAide()));
        }
    }

    @Required
    public void setPilotConverter(Converter<PilotModel, PilotData> pilotConverter) {
        this.pilotConverter = pilotConverter;
    }

    @Required
    public void setCabinCrewConverter(Converter<CabinCrewModel, CabinCrewData> cabinCrewConverter) {
        this.cabinCrewConverter = cabinCrewConverter;
    }

    public Converter<PilotModel, PilotData> getPilotConverter() {
        return pilotConverter;
    }

    public Converter<CabinCrewModel, CabinCrewData> getCabinCrewConverter() {
        return cabinCrewConverter;
    }
}
