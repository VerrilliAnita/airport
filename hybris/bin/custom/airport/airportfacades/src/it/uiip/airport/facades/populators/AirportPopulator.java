/**
 *
 */
package it.uiip.airport.facades.populators;

import de.hybris.platform.converters.Populator;
import de.hybris.platform.servicelayer.dto.converter.ConversionException;

import it.uiip.airport.core.model.AirportModel;
import it.uiip.airport.core.service.impl.DefaultAirportService;
import it.uiip.airport.facades.data.AirportData;
import org.apache.log4j.Logger;


/**
 * @author soprasteria
 *
 */


public class AirportPopulator implements Populator<AirportModel, AirportData>
{
	private static final Logger LOG = Logger.getLogger(AirportPopulator.class);

	/*
	 * (non-Javadoc)
	 * 
	 * @see de.hybris.platform.converters.Populator#populate(java.lang.Object, java.lang.Object)
	 */
	@Override
	public void populate(final AirportModel source, final AirportData target) throws ConversionException {
		LOG.info("Invoke method populate() in AirportPopulator");
		if(source.getCodeAirport() != null)
		{
			target.setCodeAirport(source.getCodeAirport());
		}
		if(source.getName() != null)
		{
			target.setName(source.getName());
		}
		if(source.getCity() != null)
		{
			target.setCity(source.getCity());
		}
		if(source.getCountry() != null)
		{
			target.setCountry(source.getCountry());
		}
		if(source.getRunways() != null)
		{
			target.setRunways(source.getRunways());
		}
	}


}
