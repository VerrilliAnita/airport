/**
 *
 */
package it.uiip.airport.core.service;

import java.util.List;

import it.uiip.airport.core.model.AirportModel;


/**
 * @author soprasteria
 *
 */
public interface AirportService
{
	public List<AirportModel> getAirportsForCity(String city);
	public AirportModel getAirportForCode(String code);
	public List<AirportModel> getAllAirport();

}
