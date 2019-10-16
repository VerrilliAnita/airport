package it.uiip.airport.facades.populators;

import de.hybris.platform.converters.Populator;
import de.hybris.platform.servicelayer.dto.converter.ConversionException;
import it.uiip.airport.core.model.PilotModel;
import it.uiip.airport.facades.data.PilotData;

public class PilotPopulator implements Populator<PilotModel, PilotData> {


    @Override
    public void populate(PilotModel source, PilotData target) throws ConversionException {
        target.setUid(source.getUid());
        target.setAge(source.getAge());
        target.setBirthday(source.getBirthday());
        target.setCodeFiscal(source.getCodeFiscal());
        target.setName(source.getName());
    }
}
