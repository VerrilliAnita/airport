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
public class PlaneReversePopulator implements Populator<PlaneData, PlaneModel>
{
	private static final Logger LOG = Logger.getLogger(PlaneReversePopulator.class);

	/*
	 * (non-Javadoc)
	 *
	 * @see de.hybris.platform.converters.Populator#populate(java.lang.Object, java.lang.Object)
	 */
	@Override
	public void populate(final PlaneData source, final PlaneModel target) throws ConversionException
	{
		LOG.info("Invoke method populate() in PlaneReversePopulator");

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
