/**
 *
 */
package it.uiip.airport.facades.populators;

import de.hybris.platform.converters.Populator;
import de.hybris.platform.servicelayer.dto.converter.ConversionException;

import it.uiip.airport.core.model.PlaneModel;
import it.uiip.airport.facades.data.PlaneData;
import org.apache.log4j.Logger;


/**
 * @author soprasteria
 *
 */
public class PlanePopulator implements Populator<PlaneModel, PlaneData>
{
	private static final Logger LOG = Logger.getLogger(PlanePopulator.class);

	@Override
	public void populate(final PlaneModel source, final PlaneData target) throws ConversionException
	{
		LOG.info("Invoke method populate() in PlanePopulator");

		if(source.getCodePlane() != null)
		{
			target.setCodePlane(source.getCodePlane());
		}
		if(source.getTypePlane() != null)
		{
			target.setTypePlane(source.getTypePlane());
		}
		if(source.getGoods() != null)
		{
			target.setGoods(source.getGoods());
		}
		if(source.getNumOfSits() != null)
		{
			target.setNumOfSits(source.getNumOfSits());
		}
	}

}
