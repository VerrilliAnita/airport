package it.uiip.airport.core.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Required;

import it.uiip.airport.core.dao.FlightDao;
import it.uiip.airport.core.model.FlightModel;
import it.uiip.airport.core.service.FlightService;

public class DefaultFlightService implements FlightService {

	private static final Logger LOG = Logger.getLogger(DefaultFlightService.class);
	 @Resource
	private FlightDao flightDao;

	 @Override
	 public List<FlightModel> getFlightsForDepartureCity(final String city) {
		LOG.info("Invoke method getFlightsForDepartureCity in DefaultFlightService");
		return flightDao.findFlightsByDepartureCity(city);
	 }

	 @Override
	 public List<FlightModel> getFlightsForDepartureDate(final Date date) {
		LOG.info("Invoke method findFlightsByDepartureDate in DefaultFlightService");
		return flightDao.findFlightsByDepartureDate(date);
	 }


	@Override
	public List<FlightModel> getAllFlights()
	{
		LOG.info("Invoke method getAllFlights in DefaultFlightService");
		return flightDao.findAllFlights();
	}


	/**
	 * @return the flightDao
	 */
	public FlightDao getFlightDao()
	{
		return flightDao;
	}

	@Required
	public void setFlightDao(final FlightDao flightDao)
	{
		this.flightDao = flightDao;
	}




}
