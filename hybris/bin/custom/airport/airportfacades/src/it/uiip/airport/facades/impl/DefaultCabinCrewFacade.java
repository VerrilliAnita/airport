package it.uiip.airport.facades.impl;

import de.hybris.platform.servicelayer.dto.converter.Converter;
import it.uiip.airport.core.model.CabinCrewModel;
import it.uiip.airport.core.service.CabinCrewService;
import it.uiip.airport.facades.CabinCrewFacade;
import it.uiip.airport.facades.data.CabinCrewData;
import org.springframework.beans.factory.annotation.Required;

import java.util.List;

public class DefaultCabinCrewFacade implements CabinCrewFacade {

    private CabinCrewService cabinCrewService;
    private Converter<CabinCrewModel,CabinCrewData> cabinCrewConverter;
    @Override
    public CabinCrewData getCabinCrewForCodeFiscal(String codeFiscal) {
        return cabinCrewConverter.convert(cabinCrewService.getCabinCrewForCodeFiscal(codeFiscal));
    }

    @Override
    public List<CabinCrewData> getCabinCrewForMaxNumberOfRoutes() {
        return cabinCrewConverter.convertAll(cabinCrewService.getCabinCrewForMaxNumberOfRoutes());
    }

    @Override
    public List<CabinCrewData> getAllCabinCrewes() {
        return cabinCrewConverter.convertAll(cabinCrewService.getAllCabinCrewes());
    }

    @Required
    public void setCabinCrewService(CabinCrewService cabinCrewService) {
        this.cabinCrewService = cabinCrewService;
    }
    @Required
    public void setCabinCrewConverter(Converter<CabinCrewModel, CabinCrewData> cabinCrewConverter) {
        this.cabinCrewConverter = cabinCrewConverter;
    }
}
