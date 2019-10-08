/**
 *
 */
package it.uiip.airport.facades;

import java.util.List;

import it.uiip.airport.facades.data.AirportRouteData;


/**
 * @author soprasteria
 *
 */
public interface AirportRouteFacade
{
	public List<AirportRouteData> getAllRoutes();

	public List<AirportRouteData> getRoutesForCode(String codeRoute);
	
	public List<AirportRouteData> getRoutesForAirportDep(String airportDep);
	
	public List<AirportRouteData> getRoutesForCommander(String commander,String month);

}
