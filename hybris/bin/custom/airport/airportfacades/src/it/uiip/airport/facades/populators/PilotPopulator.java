package it.uiip.airport.facades.populators;

import de.hybris.platform.converters.Populator;
import de.hybris.platform.servicelayer.dto.converter.ConversionException;
import it.uiip.airport.core.model.PilotModel;
import it.uiip.airport.facades.data.PilotData;

public class PilotPopulator implements Populator<PilotModel, PilotData> {

    @Override
    public void populate(PilotModel source, PilotData target) throws ConversionException {
        if(source!=null)
        {
            if(source.getUid()!=null)
            {
                target.setUid(source.getUid());
            }
            if(source.getName()!=null)
            {
                target.setName(source.getName());
            }
            if(source.getCodeFiscal()!=null)
            {
                target.setCodeFiscal(source.getCodeFiscal());
            }
            if(source.getAge()!=null)
            {
                target.setAge(source.getAge());
            }
            if(source.getBirthday()!=null)
            {
                target.setBirthday(source.getBirthday());
            }
        }
    }


}
