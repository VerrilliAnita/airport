/**
 *
 */
package it.uiip.airport.core.service.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Required;

import it.uiip.airport.core.dao.AirportRouteDao;
import it.uiip.airport.core.model.RouteModel;
import it.uiip.airport.core.service.AirportRouteService;


/**
 * @author soprasteria
 *
 */
public class DefaultAirportRouteService implements AirportRouteService
{
	private static final Logger LOG = Logger.getLogger(DefaultAirportRouteService.class);
	private AirportRouteDao airportRouteDao;

	@Override
	public List<RouteModel> getAllRoutes()
	{
		LOG.info("Invoke method findAllAirportRoute in DefaultAirportRouteService");
		return airportRouteDao.findAllAirportRoute();
	}

	@Override
	public List<RouteModel> getRoutesForStatus(final String status)
	{
		LOG.info("Invoke method findAirportRouteDeleted in DefaultAirportRouteService");
		return airportRouteDao.findAirportRouteDeleted(status);
	}


	@Override
	public List<RouteModel> getRoutesForCode(final String codeRoute)
	{
		LOG.info("Invoke method findAirportRouteByCode in DefaultAirportRouteService");
		return airportRouteDao.findAirportRouteByCode(codeRoute);
	}


	/**
	 * @return the airportRouteDao
	 */
	public AirportRouteDao getAirportRouteDao()
	{
		return airportRouteDao;
	}


	@Required
	public void setAirportRouteDao(final AirportRouteDao airportRouteDao)
	{
		this.airportRouteDao = airportRouteDao;
	}

	@Override
	public List<RouteModel> getRoutesForAirportDep(String airportDep) {
		LOG.info("Invoke method getRoutesByAirportDep in DefaultAirportRouteService");
		return airportRouteDao.findRoutesByAirportDep(airportDep);
	}

	@Override
	public List<RouteModel> getRoutesForCommander(String commander,String month) {
		LOG.info("Invoke method getRoutesByCommander in DefaultAirportRouteService");
		return airportRouteDao.findRoutesByCommander(commander,month);
	}
}
