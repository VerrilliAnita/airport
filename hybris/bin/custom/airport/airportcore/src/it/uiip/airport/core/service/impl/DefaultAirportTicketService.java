/**
 *
 */
package it.uiip.airport.core.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Required;

import it.uiip.airport.core.dao.AirportTicketDao;
import it.uiip.airport.core.model.AirportTicketModel;
import it.uiip.airport.core.service.AirportTicketService;


/**
 * @author soprasteria
 *
 */
public class DefaultAirportTicketService implements AirportTicketService
{
	private static final Logger LOG = Logger.getLogger(DefaultAirportTicketService.class);
	@Resource
	private AirportTicketDao airportTicketDao;

	@Override
	public List<AirportTicketModel> getTicketsForCodeRoute(final String codeRoute)
	{
		LOG.info("Invoke method getTicketsForCodeRoute in DefaultAirportTicketService");
		return airportTicketDao.findTicketsByCodeRoute(codeRoute);
	}

	@Override
	public List<AirportTicketModel> getTicketsForPassengerUid(final String uid)
	{
		LOG.info("Invoke method getTicketsForPassengerUid in DefaultAirportTicketService");
		return airportTicketDao.findTicketsByPassengerUid(uid);
	}

	public AirportTicketDao getAirportTicketDao()
	{
		return airportTicketDao;
	}

	@Required
	public void setAirportTicketDao(final AirportTicketDao airportTicketDao)
	{
		this.airportTicketDao = airportTicketDao;
	}

}
