/**
 *
 */
package it.uiip.airport.core.interceptor;

import de.hybris.platform.servicelayer.event.EventService;
import de.hybris.platform.servicelayer.interceptor.InterceptorContext;
import de.hybris.platform.servicelayer.interceptor.InterceptorException;
import de.hybris.platform.servicelayer.interceptor.PrepareInterceptor;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Required;

import it.uiip.airport.core.event.AfterTicketCreationEvent;
import it.uiip.airport.core.model.AirportTicketModel;


/**
 * @author soprasteria
 *
 */
public class SaveUpdateTicketInterceptor implements PrepareInterceptor<AirportTicketModel>
{
	private EventService eventService;
	private static final Logger LOG = Logger.getLogger(SaveUpdateTicketInterceptor.class);
	@Override
	public void onPrepare(final AirportTicketModel ticket, final InterceptorContext context) throws InterceptorException
	{
		LOG.info("Call onPrepare----------");
		if (context.isModified(ticket, "statusTicket"))
		{
			LOG.info("New Ticket");
			final AfterTicketCreationEvent eventCreation = new AfterTicketCreationEvent(ticket.getRoute());
			eventService.publishEvent(eventCreation);
		}
	}


	public EventService getEventService()
	{
		return eventService;
	}

	@Required
	public void setEventService(final EventService eventService)
	{
		this.eventService = eventService;
	}



}
