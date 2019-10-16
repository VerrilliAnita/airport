/**
 *
 */
package it.uiip.airport.facades.populators;

import de.hybris.platform.converters.Populator;
import de.hybris.platform.servicelayer.dto.converter.ConversionException;
import de.hybris.platform.servicelayer.dto.converter.Converter;
import it.uiip.airport.core.model.CrewModel;
import it.uiip.airport.facades.data.CrewData;
import org.apache.log4j.Logger;
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
	private static final Logger LOG = Logger.getLogger(AirportRoutePopulator.class);

	private Converter<FlightModel, FlightData> flightConverter;
	private Converter<AirportTicketModel, AirportTicketData> airportTicketConverter;
	private Converter<CrewModel, CrewData> crewConverter;


	@Override
	public void populate(final RouteModel source, final AirportRouteData target) throws ConversionException
	{

		LOG.info("Invoke method populate() in AirportRoutePopulator");
		if(source.getCodeRoute() != null)
		{
			target.setCodeRoute(source.getCodeRoute());
		}
		if(source.getFlight() != null)
		{
			target.setFlight(flightConverter.convert(source.getFlight()));
		}
		if(source.getDateRouteDep() != null)
		{
			target.setDateRouteDep(source.getDateRouteDep());
		}
		if(source.getDateRouteArr() != null)
		{
			target.setDateRouteArr(source.getDateRouteArr());
		}
		if(source.getAirportTickets() != null)
		{
			target.setTickets(airportTicketConverter.convertAll(source.getAirportTickets()));
		}
		if(source.getCrew() != null)
		{
			target.setCrew(crewConverter.convert(source.getCrew()));
		}

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

	public Converter<CrewModel, CrewData> getCrewConverter() {
		return crewConverter;
	}

	@Required
	public void setCrewConverter(Converter<CrewModel, CrewData> crewConverter) {
		this.crewConverter = crewConverter;
	}
}
