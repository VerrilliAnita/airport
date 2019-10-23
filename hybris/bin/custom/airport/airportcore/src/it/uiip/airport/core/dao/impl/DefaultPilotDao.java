package it.uiip.airport.core.dao.impl;

import de.hybris.platform.servicelayer.exceptions.ModelNotFoundException;
import de.hybris.platform.servicelayer.internal.dao.DefaultGenericDao;
import de.hybris.platform.servicelayer.search.FlexibleSearchQuery;
import de.hybris.platform.servicelayer.search.SearchResult;
import it.uiip.airport.core.dao.PilotDao;
import it.uiip.airport.core.model.PassengerModel;
import it.uiip.airport.core.model.PilotModel;

import java.util.List;

public class DefaultPilotDao extends DefaultGenericDao<PilotModel> implements PilotDao {

    public DefaultPilotDao(String typecode) {
        super(typecode);
    }

    @Override
    public PilotModel findPilotByUid(String uid) {
        final StringBuilder queryStr = new StringBuilder();
        queryStr.append("SELECT {P.pk} FROM {Pilot AS P}");
        queryStr.append("WHERE {a.uid} = ?uid");
        final FlexibleSearchQuery fsq = new FlexibleSearchQuery(queryStr);
        fsq.addQueryParameter("uid", uid);
        try
        {
            final PilotModel result = getFlexibleSearchService().searchUnique(fsq);
            return result;
        }
        catch (ModelNotFoundException e)
        {
            return null;
        }
    }

    @Override
    public List<PilotModel> findAllPilots() {
        final StringBuilder queryStr = new StringBuilder();
        queryStr.append("SELECT {P:PK}");
        queryStr.append("FROM{Pilot as P}}");
        final FlexibleSearchQuery fsq = new FlexibleSearchQuery(queryStr);
        final SearchResult<PilotModel> result = getFlexibleSearchService().search(fsq);
        return result.getResult();
    }
}
