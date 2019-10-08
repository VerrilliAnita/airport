/**
 *
 */
package it.uiip.airport.facades.impl;

import de.hybris.platform.servicelayer.dto.converter.Converter;

import java.util.List;

import org.springframework.beans.factory.annotation.Required;

import it.uiip.airport.core.model.RouteModel;
import it.uiip.airport.core.service.AirportRouteService;
import it.uiip.airport.facades.AirportRouteFacade;
import it.uiip.airport.facades.data.AirportRouteData;


/**
 * @author soprasteria
 *
 */
public class DefaultAirportRouteFacade implements AirportRouteFacade
{
	private AirportRouteService airportRouteService;
	private Converter<RouteModel, AirportRouteData> airportRouteConverter;

	@Override
	public List<AirportRouteData> getAllRoutes()
	{
		return airportRouteConverter.convertAll(airportRouteService.getAllRoutes());
	}


	@Override
	public List<AirportRouteData> getRoutesForCode(final String codeRoute)
	{
		return airportRouteConverter.convertAll(airportRouteService.getRoutesForCode(codeRoute));
	}

	public AirportRouteService getAirportRouteService()
	{
		return airportRouteService;
	}

	@Required
	public void setAirportRouteService(final AirportRouteService airportRouteService)
	{
		this.airportRouteService = airportRouteService;
	}

	public Converter<RouteModel, AirportRouteData> getAirportRouteConverter()
	{
		return airportRouteConverter;
	}

	@Required
	public void setAirportRouteConverter(final Converter<RouteModel, AirportRouteData> airportRouteConverter)
	{
		this.airportRouteConverter = airportRouteConverter;
	}


	@Override
	public List<AirportRouteData> getRoutesForAirportDep(String airportDep) {
		return airportRouteConverter.convertAll(airportRouteService.getRoutesForAirportDep(airportDep));
	}


	@Override
	public List<AirportRouteData> getRoutesForCommander(String commander,String month) {	
		return airportRouteConverter.convertAll(airportRouteService.getRoutesForCommander(commander,month));
	}



}
