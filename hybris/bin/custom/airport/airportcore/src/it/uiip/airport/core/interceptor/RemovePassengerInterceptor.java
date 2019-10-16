/**
 *
 */
package it.uiip.airport.core.interceptor;

import de.hybris.platform.servicelayer.interceptor.InterceptorContext;
import de.hybris.platform.servicelayer.interceptor.InterceptorException;
import de.hybris.platform.servicelayer.interceptor.RemoveInterceptor;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Required;

import it.uiip.airport.core.model.AirportTicketModel;
import it.uiip.airport.core.model.PassengerModel;
import it.uiip.airport.core.service.AirportTicketService;


/**
 * @author soprasteria
 *
 */
public class RemovePassengerInterceptor implements RemoveInterceptor<PassengerModel>
{
	private AirportTicketService airportTicketService;

	@Override
	public void onRemove(final PassengerModel passenger, final InterceptorContext context) throws InterceptorException
	{
		final List<AirportTicketModel> tickets = airportTicketService.getTicketsForPassengerUid(passenger.getUid());
		final Date today = new Date();
		for (final AirportTicketModel t : tickets)
		{
			if (t.getRoute().getDateRouteDep().after(today))
			{
				context.getModelService().remove(t);
			}
		}

	}

	/**
	 * @return the airportTicketService
	 */
	public AirportTicketService getAirportTicketService()
	{
		return airportTicketService;
	}

	@Required
	public void setAirportTicketService(final AirportTicketService airportTicketService)
	{
		this.airportTicketService = airportTicketService;
	}


}
