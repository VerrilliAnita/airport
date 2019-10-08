/**
 *
 */
package it.uiip.airport.core.dao;

import de.hybris.platform.servicelayer.internal.dao.GenericDao;

import java.util.List;

import it.uiip.airport.core.model.AirportTicketModel;



/**
 * @author soprasteria
 *
 */
public interface AirportTicketDao extends GenericDao<AirportTicketModel>
{
	public List<AirportTicketModel> findTicketsByCodeRoute(String codeRoute);

	public List<AirportTicketModel> findTicketsByPassengerCf(String uid);
}
