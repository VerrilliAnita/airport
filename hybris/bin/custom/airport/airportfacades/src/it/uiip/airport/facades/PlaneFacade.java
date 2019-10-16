/**
 *
 */
package it.uiip.airport.facades;

import java.util.List;

import it.uiip.airport.facades.data.PlaneData;


/**
 * @author soprasteria
 *
 */
public interface PlaneFacade
{
	public List<PlaneData> getAllPlanes();

	public List<PlaneData> getPlanesForCity(String city);
}
