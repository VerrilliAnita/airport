package it.uiip.airport.core.handler;

import java.util.Date;

import de.hybris.platform.servicelayer.model.attribute.DynamicAttributeHandler;
import it.uiip.airport.core.model.CabinCrewModel;

public class AgeCabinCrewHandler implements DynamicAttributeHandler<Integer, CabinCrewModel>{

	@Override
	public Integer get(CabinCrewModel user) {
		return user.getCurrentDate().getYear() - user.getBirthday().getYear();
	}

	@Override
	public void set(CabinCrewModel User, Integer age) {

	}

}
