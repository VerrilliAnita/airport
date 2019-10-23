/**
 *
 */
package it.uiip.airport.core.dao.impl;

import de.hybris.platform.servicelayer.exceptions.ModelNotFoundException;
import de.hybris.platform.servicelayer.internal.dao.DefaultGenericDao;
import de.hybris.platform.servicelayer.search.FlexibleSearchQuery;
import de.hybris.platform.servicelayer.search.SearchResult;

import java.util.Date;
import java.util.List;

import it.uiip.airport.core.dao.AirportRouteDao;
import it.uiip.airport.core.model.RouteModel;
import org.apache.log4j.Logger;



public class DefaultAirportRouteDao extends DefaultGenericDao<RouteModel> implements AirportRouteDao
{
	private static final Logger LOG = Logger.getLogger(DefaultAirportRouteDao.class);

	public DefaultAirportRouteDao(final String typecode) {
		super(typecode);
	}

	@Override
	public List<RouteModel> findAllAirportRoutes() {
		LOG.info("Invoke method findAllAirportRoute in DefaultAirportRouteDao");

		final StringBuilder queryStr = new StringBuilder();
		queryStr.append("SELECT {R.pk} FROM {Route AS R}");
		final FlexibleSearchQuery fsq = new FlexibleSearchQuery(queryStr);
		final SearchResult<RouteModel> result = getFlexibleSearchService().search(fsq);
		return result.getResult();
	}


	@Override
	public RouteModel findAirportRouteByCode(final String codeRoute) {
		LOG.info("Invoke method findAirportRouteByCode in DefaultAirportRouteDao");

		final StringBuilder queryStr = new StringBuilder();
		queryStr.append("SELECT {R.pk} FROM {Route AS R}");
		queryStr.append("WHERE {R.codeRoute}=?codeRoute");
		final FlexibleSearchQuery fsq = new FlexibleSearchQuery(queryStr);
		fsq.addQueryParameter("codeRoute", codeRoute);
		try {
			final RouteModel result = getFlexibleSearchService().searchUnique(fsq);
			return result;
		}catch (ModelNotFoundException e) {
			return null;
		}
	}

	@Override
	public List<RouteModel> findAirportRoutesByStatus(final String status) {
		LOG.info("Invoke method findAirportRouteDeleted in DefaultAirportRouteDao");

		final StringBuilder queryStr = new StringBuilder();
		queryStr.append("SELECT {R.pk} FROM {Route AS R join statusRouteEnum as E on {E.pk}={R.statusRoute} }");
		queryStr.append("WHERE {E.code}= ?status");
		final FlexibleSearchQuery fsq = new FlexibleSearchQuery(queryStr);
		fsq.addQueryParameter("status", status);
		final SearchResult<RouteModel> result = getFlexibleSearchService().search(fsq);
		return result.getResult();
	}


	@Override
	public List<RouteModel> findAirportRouteByCityAndDay(String city, Date day) {
		LOG.info("Invoke method findAirportRouteByCityAndDay in DefaultAirportRouteDao");

		final StringBuilder queryStr = new StringBuilder();
		queryStr.append("Select {R.pk}");
		queryStr.append("FROM {Route AS R JOIN Flight as F ON {R.flight}={F.pk}");
		queryStr.append("JOIN Airport AS A ON {F.airportDep}={A.pk} }");
		queryStr.append("WHERE {A.city}=?city AND {R.dateRouteDep} LIKE ? day%");
		final FlexibleSearchQuery fsq = new FlexibleSearchQuery(queryStr);
		fsq.addQueryParameter("city", city);
		fsq.addQueryParameter("day", day);
		final SearchResult<RouteModel> result = getFlexibleSearchService().search(fsq);
		return result.getResult();
	}


	@Override
	public List<RouteModel> findRoutesByAirportDep(String airport) {
		LOG.info("Invoke method findRoutesByAirportDep in DefaultAirportRouteDao");

		final StringBuilder queryStr = new StringBuilder();
		queryStr.append("Select {R.pk}");
		queryStr.append("FROM {Route AS R JOIN Crew AS C ON {R.crew} = {C.PK} JOIN Flight as F ON {R.flight}={F.pk}");
		queryStr.append("JOIN Airport AS A ON {F.airportDep}={A.pk} }");
		queryStr.append("WHERE {A.codeAirport} = ?airport");
		final FlexibleSearchQuery fsq = new FlexibleSearchQuery(queryStr);
		fsq.addQueryParameter("airport", airport);
		final SearchResult<RouteModel> result = getFlexibleSearchService().search(fsq);
		return result.getResult();
	}


	@Override
	public List<RouteModel> findRoutesByCommander(String commander,String month) {
		LOG.info("Invoke method findRoutesByCommander in DefaultAirportRouteDao");

		final StringBuilder queryStr = new StringBuilder();
		queryStr.append("Select {R.pk}");
		queryStr.append("FROM {ROUTE AS R JOIN CREW AS C ON {R.crew}={C.pk}");
		queryStr.append("JOIN PILOT AS P ON {C.commander}={P.pk} }");
		queryStr.append("WHERE {P.name}=?commander AND {R.dateRouteDep} LIKE CONCAT('%', CONCAT( ?month, '%'))");
		final FlexibleSearchQuery fsq = new FlexibleSearchQuery(queryStr);
		fsq.addQueryParameter("commander", commander);
		fsq.addQueryParameter("month", month);
		final SearchResult<RouteModel> result = getFlexibleSearchService().search(fsq);
		return result.getResult();
	}
	
	

}
