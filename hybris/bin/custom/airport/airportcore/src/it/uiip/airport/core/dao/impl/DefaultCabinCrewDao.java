package it.uiip.airport.core.dao.impl;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

import de.hybris.platform.servicelayer.exceptions.ModelNotFoundException;
import de.hybris.platform.servicelayer.search.FlexibleSearchQuery;
import de.hybris.platform.servicelayer.search.SearchResult;
import de.hybris.platform.servicelayer.internal.dao.DefaultGenericDao;


import it.uiip.airport.core.dao.CabinCrewDao;
import it.uiip.airport.core.model.CabinCrewModel;


public class DefaultCabinCrewDao extends DefaultGenericDao<CabinCrewModel> implements CabinCrewDao {

	public DefaultCabinCrewDao(String typecode) {
		super(typecode);
		// TODO Auto-generated constructor stub
	}

	@Override
	public CabinCrewModel findCabinCrewByCodeFiscal(String codeFiscal) {
		final StringBuilder queryStr = new StringBuilder();
		queryStr.append("SELECT {CC.pk} FROM {CabinCrew AS CC}");
		queryStr.append("WHERE {CC.codeFiscal} = ?codeFiscal");
		final FlexibleSearchQuery fsq = new FlexibleSearchQuery(queryStr);
		fsq.addQueryParameter("codeFiscal", codeFiscal);
		try
		{
			final CabinCrewModel result = getFlexibleSearchService().searchUnique(fsq);
			return result;
		}
		catch (ModelNotFoundException e)
		{
			return null;
		}
	}

	@Override
	 public List<CabinCrewModel> findCabinCrewByMaxNumberOfRoutes() {
		  Date date = new Date();
		  LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		  int monthInt = localDate.getMonthValue();
		  String month = String.format("%02d", monthInt);
		  final StringBuilder queryStr = new StringBuilder();
		  queryStr.append("SELECT MAX({cc.pk}) FROM {CabinCrew AS cc ");
		  queryStr.append("JOIN Crew AS c ON {cc.crew} = {c.pk} ");
		  queryStr.append("JOIN Route AS r ON {c.pk} = {r.crew}} ");
		  queryStr.append("WHERE {r.dateRouteDep} LIKE %-?month-%");
		  final FlexibleSearchQuery fsq = new FlexibleSearchQuery(queryStr);
		  fsq.addQueryParameter("month", month);
		  final SearchResult<CabinCrewModel> result = getFlexibleSearchService().search(fsq);
		  return result.getResult();
		 }

	@Override
	public List<CabinCrewModel> findAllCabinCrewes() {
		  final StringBuilder queryStr = new StringBuilder();
		  queryStr.append("SELECT {CC.pk} FROM {CabinCrew AS CC }");
		  final FlexibleSearchQuery fsq = new FlexibleSearchQuery(queryStr);
		  final SearchResult<CabinCrewModel> result = getFlexibleSearchService().search(fsq);
		  return result.getResult();
	}

	

}
