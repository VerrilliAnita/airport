/**
 *
 */
package it.uiip.airport.facades.populators;

import de.hybris.platform.converters.Populator;
import de.hybris.platform.servicelayer.dto.converter.ConversionException;
import de.hybris.platform.servicelayer.dto.converter.Converter;

import org.springframework.beans.factory.annotation.Required;

import it.uiip.airport.core.model.AirportTicketModel;
import it.uiip.airport.core.model.FlightModel;
import it.uiip.airport.core.model.RouteModel;
import it.uiip.airport.facades.data.AirportRouteData;
import it.uiip.airport.facades.data.AirportTicketData;
import it.uiip.airport.facades.data.FlightData;




/**
 * @author soprasteria
 *
 */
public class AirportRoutePopulator implements Populator<RouteModel, AirportRouteData>
{
	private Converter<FlightModel, FlightData> flightConverter;
	private Converter<AirportTicketModel, AirportTicketData> airportTicketConverter;

	@Override
	public void populate(final RouteModel source, final AirportRouteData target) throws ConversionException
	{
		target.setCodeRoute(source.getCodeRoute());
		target.setFlight(flightConverter.convert(source.getFlight()));
		target.setDateRouteDep(source.getDateRouteDep());
		target.setDateRouteArr(source.getDateRouteArr());
		target.setTickets(airportTicketConverter.convertAll(source.getAirportTickets()));

	}

	public Converter<AirportTicketModel, AirportTicketData> getAirportTicketConverter()
	{
		return airportTicketConverter;
	}

	@Required
	public void setAirportTicketConverter(final Converter<AirportTicketModel, AirportTicketData> airportTicketConverter)
	{
		this.airportTicketConverter = airportTicketConverter;
	}

	public Converter<FlightModel, FlightData> getFlightConverter()
	{
		return flightConverter;
	}


	@Required
	public void setFlightConverter(final Converter<FlightModel, FlightData> flightConverter)
	{
		this.flightConverter = flightConverter;
	}

}
