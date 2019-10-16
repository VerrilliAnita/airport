/**
 *
 */
package it.uiip.airport.core.dao.impl;

import de.hybris.platform.servicelayer.internal.dao.DefaultGenericDao;
import de.hybris.platform.servicelayer.search.FlexibleSearchQuery;
import de.hybris.platform.servicelayer.search.SearchResult;

import java.util.List;

import it.uiip.airport.core.dao.AirportTicketDao;
import it.uiip.airport.core.model.AirportTicketModel;


/**
 * @author soprasteria
 *
 */
public class DefaultAirportTicketDao extends DefaultGenericDao<AirportTicketModel> implements AirportTicketDao
{
	/**
	 * @param typecode
	 */
	public DefaultAirportTicketDao(final String typecode)
	{
		super(typecode);
	}


	@Override
	public List<AirportTicketModel> findTicketsByCodeRoute(final String codeRoute)
	{
		final StringBuilder queryStr = new StringBuilder();
		queryStr.append("SELECT T.pk FROM {AirportTicket as T }");
		queryStr.append("WHERE {T.route} = ?codeRoute");
		final FlexibleSearchQuery fsq = new FlexibleSearchQuery(queryStr);
		fsq.addQueryParameter("codeRoute", codeRoute);
		final SearchResult<AirportTicketModel> result = getFlexibleSearchService().search(fsq);
		return result.getResult();
	}


	/*
	 * (non-Javadoc)
	 *
	 * @see it.uiip.airport.core.dao.AirportTicketDao#findTicketsByPassengerCf(java.lang.String)
	 */
	@Override
	public List<AirportTicketModel> findTicketsByPassengerUid(final String uid)
	{
		final StringBuilder queryStr = new StringBuilder();
		queryStr.append("SELECT {T.Pk} FROM {AirportTicket as T join Passenger as P on {P.pk}={T.passenger} }");
		queryStr.append("WHERE {P.uid} = ?uid");
		final FlexibleSearchQuery fsq = new FlexibleSearchQuery(queryStr);
		fsq.addQueryParameter("uid", uid);
		final SearchResult<AirportTicketModel> result = getFlexibleSearchService().search(fsq);
		return result.getResult();
	}

}
