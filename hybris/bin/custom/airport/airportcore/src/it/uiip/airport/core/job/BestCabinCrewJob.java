package it.uiip.airport.core.job;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Required;

import de.hybris.platform.cronjob.enums.CronJobResult;
import de.hybris.platform.cronjob.enums.CronJobStatus;
import de.hybris.platform.cronjob.model.CronJobModel;
import de.hybris.platform.servicelayer.cronjob.AbstractJobPerformable;
import de.hybris.platform.servicelayer.cronjob.PerformResult;
import it.uiip.airport.core.model.CabinCrewModel;
import it.uiip.airport.core.service.CabinCrewService;

public class BestCabinCrewJob extends AbstractJobPerformable<CronJobModel>{
	
	private CabinCrewService cabinCrewService;
	private static final Logger LOG = Logger.getLogger(BestCabinCrewJob.class);

	@Override
	public PerformResult perform(CronJobModel arg0) {
		LOG.info("method perform");
		final List<CabinCrewModel> allCabinCrewes = cabinCrewService.getAllCabinCrewes();
		final List<CabinCrewModel> cabinCrewes = cabinCrewService.getCabinCrewForMaxNumberOfRoutes();
		if(cabinCrewes == null || allCabinCrewes == null) {
			LOG.error("Not Found Best Cabin Crew ");
			return new PerformResult(CronJobResult.UNKNOWN, CronJobStatus.FINISHED);
		}
		for (CabinCrewModel cabinCrew : allCabinCrewes) {
			cabinCrew.setIsBest(false);
			this.modelService.save(cabinCrew);
		}
		for (CabinCrewModel cabinCrew : cabinCrewes) {
			cabinCrew.setIsBest(true);
			this.modelService.save(cabinCrew);
		}
		
		return new PerformResult(CronJobResult.SUCCESS, CronJobStatus.FINISHED);
	}

	public CabinCrewService getCabinCrewService() {
		return cabinCrewService;
	}
	
	@Required
	public void setCabinCrewService(CabinCrewService cabinCrewService) {
		this.cabinCrewService = cabinCrewService;
	}
	
	

}
