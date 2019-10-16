/**
 *
 */
package it.uiip.airport.core.dao.impl;

import de.hybris.platform.servicelayer.exceptions.ModelNotFoundException;
import de.hybris.platform.servicelayer.internal.dao.DefaultGenericDao;
import de.hybris.platform.servicelayer.search.FlexibleSearchQuery;
import de.hybris.platform.servicelayer.search.SearchResult;

import java.util.List;

import it.uiip.airport.core.dao.AirportDao;
import it.uiip.airport.core.model.AirportModel;
import it.uiip.airport.core.service.impl.DefaultAirportService;
import org.apache.log4j.Logger;

public class DefaultAirportDao extends DefaultGenericDao<AirportModel> implements AirportDao
{
	private static final Logger LOG = Logger.getLogger(DefaultAirportDao.class);

	public DefaultAirportDao(final String typecode) {
		super(typecode);
	}

	@Override
	public List<AirportModel> findAirportsByCity(final String city) {
		LOG.info("Invoke method findAirportsByCity in DefaultAirportDao");
		final StringBuilder queryStr = new StringBuilder();
		queryStr.append("SELECT {a.pk} FROM {Airport AS a}");
		queryStr.append("WHERE {a.city} = ?city");
		final FlexibleSearchQuery fsq = new FlexibleSearchQuery(queryStr);
		fsq.addQueryParameter("city", city);
		final SearchResult<AirportModel> result = getFlexibleSearchService().search(fsq);
		return result.getResult();
	}


	@Override
	public List<AirportModel> findAllAirport() {
		LOG.info("Invoke method findAllAirport in DefaultAirportDao");
		final StringBuilder queryStr = new StringBuilder();
		queryStr.append("SELECT {a.pk} FROM {Airport AS a}");
		final FlexibleSearchQuery fsq = new FlexibleSearchQuery(queryStr);
		final SearchResult<AirportModel> result = getFlexibleSearchService().search(fsq);
		return result.getResult();
	}

	@Override
	public AirportModel findAirportByCode(String codeAirport) {
		LOG.info("Invoke method findAirportByCode in DefaultAirportDao");
		final StringBuilder queryStr = new StringBuilder();
		queryStr.append("SELECT {a.pk} FROM {Airport AS a} WHERE {a.codeAirport} = ?codeAirport");
		final FlexibleSearchQuery fsq = new FlexibleSearchQuery(queryStr);
		fsq.addQueryParameter("codeAirport", codeAirport);
		try {
			final AirportModel result = getFlexibleSearchService().searchUnique(fsq);
			return result;
		} catch (ModelNotFoundException e) {
			return null;
		}
	}


}
