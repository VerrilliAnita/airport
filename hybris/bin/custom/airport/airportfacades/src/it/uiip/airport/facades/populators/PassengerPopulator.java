package it.uiip.airport.facades.populators;

import de.hybris.platform.converters.Populator;
import de.hybris.platform.servicelayer.dto.converter.ConversionException;
import it.uiip.airport.core.model.PassengerModel;
import it.uiip.airport.facades.data.PassengerData;

public class PassengerPopulator implements Populator <PassengerModel,PassengerData>{

	@Override
	public void populate(PassengerModel source, PassengerData target) throws ConversionException {
		if(source!=null)
		{
			if(source.getName()!=null)
			{
				target.setName(source.getName());
			}
			if(source.getCodeFiscal()!=null)
			{
				target.setCodeFiscal(source.getCodeFiscal());
			}
			if(source.getBirthday()!=null)
			{
				target.setBirthday(source.getBirthday());
			}
			if(source.getAge()!=null)
			{
				target.setAge(source.getAge());
			}
		}

		
	}

}
