/**
 *
 */
package it.uiip.airport.core.event;

import de.hybris.platform.servicelayer.event.events.AbstractEvent;

import it.uiip.airport.core.model.RouteModel;


/**
 * @author soprasteria
 *
 */
public class AfterTicketCreationEvent extends AbstractEvent
{
	private final RouteModel route;

	public AfterTicketCreationEvent(final RouteModel route)
	{
		this.route = route;
	}

	public RouteModel getRoute()
	{
		return route;
	}


}
