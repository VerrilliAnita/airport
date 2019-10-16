/**
 *
 */
package it.uiip.airport.facades;

import java.util.Date;
import java.util.List;

import it.uiip.airport.facades.data.FlightData;


/**
 * @author soprasteria
 *
 */
public interface FlightFacade
{
	public List<FlightData> getAllFlights();
	public List<FlightData> getFlightsForDepartureDate(Date date);
	public List<FlightData> getFlightsForDepartureCity(String city);
}
