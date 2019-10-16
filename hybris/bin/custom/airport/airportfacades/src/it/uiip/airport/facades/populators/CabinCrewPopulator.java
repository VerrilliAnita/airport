package it.uiip.airport.facades.populators;

import de.hybris.platform.converters.Populator;
import de.hybris.platform.servicelayer.dto.converter.ConversionException;
import de.hybris.platform.servicelayer.dto.converter.Converter;
import it.uiip.airport.core.model.CabinCrewModel;
import it.uiip.airport.core.model.CrewModel;
import it.uiip.airport.facades.data.CabinCrewData;
import it.uiip.airport.facades.data.CrewData;
import org.springframework.beans.factory.annotation.Required;

public class CabinCrewPopulator implements Populator<CabinCrewModel, CabinCrewData> {


    @Override
    public void populate(CabinCrewModel source, CabinCrewData target) throws ConversionException {
        target.setUid(source.getUid());
        target.setName(source.getName());
        target.setAge(source.getAge());
        target.setBirthday(source.getBirthday());
        target.setCodeFiscal(source.getCodeFiscal());
    }


}
