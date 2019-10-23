/**
 *
 */
package it.uiip.airport.core.dao;

import java.util.Date;
import java.util.List;

import it.uiip.airport.core.model.RouteModel;


/**
 * @author soprasteria
 *
 */
public interface AirportRouteDao
{
	public List<RouteModel> findAllAirportRoutes();
	
	public List<RouteModel> findAirportRouteByCityAndDay(String city,Date day);

	public RouteModel findAirportRouteByCode(String codeRoute);

	public List<RouteModel> findAirportRoutesByStatus(String status);
	
	public List<RouteModel> findRoutesByAirportDep(String airport);
	
	public List<RouteModel> findRoutesByCommander(String commander,String month);
	
}
