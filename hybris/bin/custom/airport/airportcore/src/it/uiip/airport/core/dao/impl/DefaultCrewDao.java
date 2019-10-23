package it.uiip.airport.core.dao.impl;

import de.hybris.platform.servicelayer.exceptions.ModelNotFoundException;
import de.hybris.platform.servicelayer.internal.dao.DefaultGenericDao;
import de.hybris.platform.servicelayer.search.FlexibleSearchQuery;
import de.hybris.platform.servicelayer.search.SearchResult;
import it.uiip.airport.core.dao.CrewDao;
import it.uiip.airport.core.model.AirportModel;
import it.uiip.airport.core.model.CrewModel;
import org.apache.log4j.Logger;

import java.util.List;

public class DefaultCrewDao extends DefaultGenericDao<CrewModel>  implements CrewDao {

    private static final Logger LOG = Logger.getLogger(DefaultCrewDao.class);

    public DefaultCrewDao(final String typecode) {
        super(typecode);
    }

    @Override
    public List<CrewModel> findAllCrewes() {
        LOG.info("Invoke method findAllCrew in DefaultCrewDao");

        final StringBuilder queryStr = new StringBuilder();
        queryStr.append("SELECT {c.pk} FROM {Crew AS c}");
        final FlexibleSearchQuery fsq = new FlexibleSearchQuery(queryStr);
        final SearchResult<CrewModel> result = getFlexibleSearchService().search(fsq);
        return result.getResult();
    }

    @Override
    public CrewModel findCrewByCode(String codeCrew) {
        LOG.info("Invoke method findCrewByCode in DefaultCrewDao");
        final StringBuilder queryStr = new StringBuilder();
        queryStr.append("SELECT {c.pk} FROM {Crew AS c} WHERE {c.codeCrew} = ?codeCrew");
        final FlexibleSearchQuery fsq = new FlexibleSearchQuery(queryStr);
        fsq.addQueryParameter("codeCrew", codeCrew);
        try {
            final CrewModel result = getFlexibleSearchService().searchUnique(fsq);
            return result;
        } catch (ModelNotFoundException e) {
            return null;
        }
    }
}
