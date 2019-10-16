/**
 *
 */
package it.uiip.airport.facades.populators;

import de.hybris.platform.converters.Populator;
import de.hybris.platform.servicelayer.dto.converter.ConversionException;
import de.hybris.platform.servicelayer.dto.converter.Converter;

import org.springframework.beans.factory.annotation.Required;

import it.uiip.airport.core.model.AirportTicketModel;
import it.uiip.airport.core.model.PassengerModel;
import it.uiip.airport.facades.data.AirportTicketData;
import it.uiip.airport.facades.data.PassengerData;





/**
 * @author soprasteria
 *
 */
public class AirportTicketPopulator implements Populator<AirportTicketModel, AirportTicketData>
{
	private Converter<PassengerModel, PassengerData> passengerConverter;


	@Override
	public void populate(final AirportTicketModel source, final AirportTicketData target) throws ConversionException
	{
		if(source!=null)
		{
			if(source.getCodeAirportTicket()!=null)
			{
				target.setCodeAirportTicket(source.getCodeAirportTicket());
			}
			if(source.getPassenger()!=null)
			{
				target.setPassenger(passengerConverter.convert(source.getPassenger()));
			}
			if(source.getPrice()!=null)
			{
				target.setPrice(source.getPrice());
			}
			if(source.getSeat()!=null)
			{
				target.setSeat(source.getSeat());
			}

		}
	}


	/**
	 * @return the passengerConverter
	 */
	public Converter<PassengerModel, PassengerData> getPassengerConverter()
	{
		return passengerConverter;
	}

	@Required
	public void setPassengerConverter(final Converter<PassengerModel, PassengerData> passengerConverter)
	{
		this.passengerConverter = passengerConverter;
	}


}
