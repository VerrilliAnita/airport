/**
 *
 */
package it.uiip.airport.core.service;

import java.util.List;

import it.uiip.airport.core.model.RouteModel;


/**
 * @author soprasteria
 *
 */
public interface AirportRouteService
{
	public List<RouteModel> getAllRoutes();

	public RouteModel getRouteForCode(String codeRoute);

	public List<RouteModel> getRoutesForStatus(String status);
	
	public List<RouteModel> getRoutesForAirportDep(String airportDep);
	
	public List<RouteModel> getRoutesForCommander(String commander, String month);

}
