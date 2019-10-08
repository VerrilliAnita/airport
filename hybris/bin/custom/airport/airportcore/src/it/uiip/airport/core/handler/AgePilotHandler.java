package it.uiip.airport.core.handler;

import java.util.Date;

import de.hybris.platform.servicelayer.model.attribute.DynamicAttributeHandler;
import it.uiip.airport.core.model.PilotModel;

public class AgePilotHandler implements DynamicAttributeHandler<Integer, PilotModel>{

	@Override
	public Integer get(PilotModel user) {
		return user.getCurrentDate().getYear() - user.getBirthday().getYear();
	}

	@Override
	public void set(PilotModel User, Integer age) {

	}

}
