/**
 *
 */
package it.uiip.airport.core.service.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Required;

import it.uiip.airport.core.dao.AirportDao;
import it.uiip.airport.core.model.AirportModel;
import it.uiip.airport.core.service.AirportService;


/**
 * @author soprasteria
 *
 */
public class DefaultAirportService implements AirportService
{
	private static final Logger LOG = Logger.getLogger(DefaultAirportService.class);
	private AirportDao airportDao;


	public AirportDao getAirportDao() {

		return airportDao;
	}

	@Required
	public void setAirportDao(final AirportDao airportDao) {
		this.airportDao = airportDao;
	}

	@Override
	public List<AirportModel> getAirportsForCity(final String city) {
		LOG.info("Invoke method getAirportsForCity in DefaultAirportService");
		return airportDao.findAirportsByCity(city);
	}

	@Override
	public List<AirportModel> getAllAirport() {
		LOG.info("Invoke method getAllAirport in DefaultAirportService");
		return airportDao.findAllAirport();
	}

	@Override
	public AirportModel getAirportsForCode(String code) {
		LOG.info("Invoke method getAirportsForCode in DefaultAirportService");
		return airportDao.findAirportByCode(code);
	}


}
