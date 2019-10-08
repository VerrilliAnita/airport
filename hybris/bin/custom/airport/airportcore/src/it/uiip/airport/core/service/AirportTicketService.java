/**
 *
 */
package it.uiip.airport.core.service;

import java.util.List;

import it.uiip.airport.core.model.AirportTicketModel;


/**
 * @author soprasteria
 *
 */
public interface AirportTicketService
{
	public List<AirportTicketModel> getTicketsForCodeRoute(String codeRoute);

	public List<AirportTicketModel> getTicketsForPassenger(String uid);
}
