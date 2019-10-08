/**
 *
 */
package it.uiip.airport.core.event;

import de.hybris.platform.servicelayer.config.ConfigurationService;
import de.hybris.platform.servicelayer.event.impl.AbstractEventListener;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Required;

import it.uiip.airport.core.enums.StatusTicketEnum;
import it.uiip.airport.core.model.AirportTicketModel;
import it.uiip.airport.core.model.RouteModel;


/**
 * @author soprasteria
 *
 */
public class AfterTicketCreationEventListener extends AbstractEventListener<AfterTicketCreationEvent>
{
	private static final Logger LOG = Logger.getLogger(AfterTicketCreationEventListener.class);
	private ConfigurationService configurationService;
	@Override
	protected void onEvent(final AfterTicketCreationEvent event)
	{
		final RouteModel route = event.getRoute();
		final String path = configurationService.getConfiguration().getString("airportcore.ticketList.file") + route.getCodeRoute()
				+ ".txt";


		PrintWriter fw = null;
		try
		{
			if (validateObject(route))
			{
				fw = new PrintWriter(new File(path));
				fw.println("FLIGHT--- Airport Departure: " + route.getFlight().getAirportDep().getName() + "Airport Arrival: "
						+ route.getFlight().getAirportArr().getName());
				fw.println(
						"Date--- Departure: " + route.getDateRouteDep().toString() + " Arrival: " + route.getDateRouteArr().toString());

				fw.println("\nPassenger List --- Seat \n");
				for (final AirportTicketModel ticket : route.getAirportTickets())
				{
					if (ticket.getStatusTicket() != null)
					{
						if (!StatusTicketEnum.DELETED.equals(ticket.getStatusTicket()))
						{
							fw.println(ticket.getPassenger().getName() + " ---" + ticket.getSeat() + "\n");
						}
					}
				}
				fw.flush();
			}
			else
			{
				LOG.error("Object null");
			}
		}
		catch (final FileNotFoundException e1)
		{
			LOG.error("File not found");

		}
		finally
		{
			fw.close();
		}
	}

	private boolean validateObject(final RouteModel route)
	{
		if (route == null || route.getAirportTickets() == null || route.getFlight() == null
				|| route.getFlight().getAirportArr() == null || route.getFlight().getAirportDep() == null
				|| route.getDateRouteDep() == null || route.getDateRouteArr() == null)
		{
			return false;
		}
		return true;
	}

	public ConfigurationService getConfigurationService()
	{
		return configurationService;
	}

	@Required
	public void setConfigurationService(final ConfigurationService configurationService)
	{
		this.configurationService = configurationService;
	}



}
