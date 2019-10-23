package it.uiip.airport.core.handler;

import java.util.Date;

import de.hybris.platform.servicelayer.model.attribute.DynamicAttributeHandler;
import it.uiip.airport.core.model.PassengerModel;

public class AgePassengerHandler implements DynamicAttributeHandler<Integer, PassengerModel>{

	@Override
	public Integer get(PassengerModel user) {
		return user.getCurrentDate().getYear() - user.getBirthday().getYear();
	}

	@Override
	public void set(PassengerModel User, Integer age) {
		throw new UnsupportedOperationException();
	}

}
