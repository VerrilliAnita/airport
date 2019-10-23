package it.uiip.airport.core.service.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Required;

import it.uiip.airport.core.dao.CabinCrewDao;
import it.uiip.airport.core.model.CabinCrewModel;
import it.uiip.airport.core.service.CabinCrewService;

public class DefaultCabinCrewService implements CabinCrewService{
	
	private static final Logger LOG = Logger.getLogger(DefaultAirportService.class);
	private CabinCrewDao cabinCrewDao;

	@Override
	public CabinCrewModel getCabinCrewForCodeFiscal(String codeFiscal) {
		LOG.info("Invoke method getCabinCrewForCodeFiscal in DefaultCabinCrewService");
		return cabinCrewDao.findCabinCrewByCodeFiscal(codeFiscal);
	}

	@Override
	public List<CabinCrewModel> getCabinCrewForMaxNumberOfRoutes() {
		LOG.info("Invoke method getCabinCrewForMaxNumberOfRoutes in DefaultCabinCrewService");
		return cabinCrewDao.findCabinCrewByMaxNumberOfRoutes();
	}

	@Override
	public List<CabinCrewModel> getAllCabinCrewes() {
		LOG.info("Invoke method getAllCabinCrewes in DefaultCabinCrewService");
		return cabinCrewDao.findAllCabinCrewes();
	}

	public CabinCrewDao getCabinCrewDao() {
		return cabinCrewDao;
	}

	@Required
	public void setCabinCrewDao(CabinCrewDao cabinCrewDao) {
		this.cabinCrewDao = cabinCrewDao;
	}
	
	

}
