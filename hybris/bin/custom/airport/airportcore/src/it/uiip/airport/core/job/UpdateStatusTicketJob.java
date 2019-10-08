/**
 *
 */
package it.uiip.airport.core.job;

import de.hybris.platform.cronjob.enums.CronJobResult;
import de.hybris.platform.cronjob.enums.CronJobStatus;
import de.hybris.platform.cronjob.model.CronJobModel;
import de.hybris.platform.servicelayer.cronjob.AbstractJobPerformable;
import de.hybris.platform.servicelayer.cronjob.PerformResult;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Required;

import it.uiip.airport.core.enums.StatusTicketEnum;
import it.uiip.airport.core.model.AirportTicketModel;
import it.uiip.airport.core.model.RouteModel;
import it.uiip.airport.core.service.AirportRouteService;


/**
 * @author soprasteria
 *
 */
public class UpdateStatusTicketJob extends AbstractJobPerformable<CronJobModel>
{
	private AirportRouteService airportRouteService;
	private static final Logger LOG = Logger.getLogger(UpdateStatusTicketJob.class);

	@Override
	public PerformResult perform(final CronJobModel arg0)
	{
		LOG.info("method perform");
		final List<RouteModel> routes = airportRouteService.getRoutesForStatus("DELETED");
		if (routes.size() > 0)
		{
			for (final RouteModel route : routes)
			{
				if (route.getAirportTickets() != null)
				{
					for (final AirportTicketModel ticket : route.getAirportTickets())
					{
						ticket.setStatusTicket(StatusTicketEnum.DELETED);
						this.modelService.save(ticket);
					}
				}
			}
		}
		return new PerformResult(CronJobResult.SUCCESS, CronJobStatus.FINISHED);
	}

	public AirportRouteService getAirportRouteService()
	{
		return airportRouteService;
	}

	@Required
	public void setAirportRouteService(final AirportRouteService airportRouteService)
	{
		this.airportRouteService = airportRouteService;
	}
}
