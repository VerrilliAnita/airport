/**
 *
 */
package it.uiip.airport.core.dao.impl;

import de.hybris.platform.servicelayer.internal.dao.DefaultGenericDao;
import de.hybris.platform.servicelayer.search.FlexibleSearchQuery;
import de.hybris.platform.servicelayer.search.SearchResult;

import java.util.List;

import it.uiip.airport.core.dao.PlaneDao;
import it.uiip.airport.core.model.PlaneModel;
import org.apache.log4j.Logger;

/**
 * @author soprasteria
 *
 */
public class DefaultPlaneDao extends DefaultGenericDao<PlaneModel> implements PlaneDao {

	private static final Logger LOG = Logger.getLogger(DefaultPlaneDao.class);

	public DefaultPlaneDao(final String typecode) {
		super(typecode);
	}

	@Override
	public List<PlaneModel> findPlanesByCity(final String city) {
		LOG.info("Invoke method findPlanesByCity in DefaultPlaneDao");

		final StringBuilder queryStr= new StringBuilder();
		queryStr.append("SELECT * FROM {Plane as p JOIN Flight AS f");
		queryStr.append("ON {f.plane} = {p.PK} JOIN Route AS r");
		queryStr.append("ON {r.flight} = {f.PK} JOIN Airport AS a");
		queryStr.append("ON {f.airportArr} = {a.PK}}");
		queryStr.append("WHERE {a.city} = ?city");
		final FlexibleSearchQuery fsq = new FlexibleSearchQuery(queryStr);
		fsq.addQueryParameter("city", city);
		final SearchResult<PlaneModel> result = getFlexibleSearchService().search(fsq);
		return result.getResult();
	}


	@Override
	public List<PlaneModel> findAllPlanes() {
		LOG.info("Invoke method findAllPlanes in DefaultPlaneDao");

		final StringBuilder queryStr = new StringBuilder();
		queryStr.append("SELECT * FROM {Plane as p}}");
		final FlexibleSearchQuery fsq = new FlexibleSearchQuery(queryStr);
		final SearchResult<PlaneModel> result = getFlexibleSearchService().search(fsq);
		return result.getResult();
	}

}
