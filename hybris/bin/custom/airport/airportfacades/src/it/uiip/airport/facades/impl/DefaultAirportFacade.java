/**
 *
 */
package it.uiip.airport.facades.impl;

import de.hybris.platform.servicelayer.dto.converter.Converter;

import java.util.List;

import it.uiip.airport.facades.populators.AirportPopulator;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Required;

import it.uiip.airport.core.model.AirportModel;
import it.uiip.airport.core.service.AirportService;
import it.uiip.airport.facades.AirportFacade;
import it.uiip.airport.facades.data.AirportData;

/**
 * @author soprasteria
 *
 */
public class DefaultAirportFacade implements AirportFacade
{
	private static final Logger LOG = Logger.getLogger(DefaultAirportFacade.class);

	private AirportService airportService;

	private Converter<AirportModel, AirportData> airportConverter;


	public AirportService getAirportService() {

		return airportService;
	}

	@Required
	public void setAirportService(final AirportService airportService) {
		this.airportService = airportService;
	}

	public Converter<AirportModel, AirportData> getAirportConverter() {
		return airportConverter;
	}

	@Required
	public void setAirportConverter(final Converter<AirportModel, AirportData> airportConverter) {
		this.airportConverter = airportConverter;
	}

	@Override
	public List<AirportData> getAllAirport() {
		LOG.info("Invoke method getAllAirport() in DefaultAirportFacade");
		return airportConverter.convertAll(airportService.getAllAirport());
	}

	@Override
	public List<AirportData> getAirportsForCity(final String city) {
		LOG.info("Invoke method getAirportsForCity in DefaultAirportFacade");
		return airportConverter.convertAll(airportService.getAirportsForCity(city));
	}

	@Override
	public AirportData getAirportsForCode(String code) {
		LOG.info("Invoke method getAirportsforCity in DefaultAirportFacade");
		return airportConverter.convert(airportService.getAirportsForCode(code));
	}


}
