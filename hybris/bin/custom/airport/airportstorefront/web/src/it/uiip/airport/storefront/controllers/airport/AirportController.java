/**
 *
 */
package it.uiip.airport.storefront.controllers.airport;

import de.hybris.platform.acceleratorstorefrontcommons.controllers.pages.AbstractPageController;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.uiip.airport.facades.AirportFacade;
import it.uiip.airport.facades.AirportRouteFacade;
import it.uiip.airport.facades.AirportTicketFacade;
import it.uiip.airport.facades.data.AirportData;
import it.uiip.airport.facades.data.AirportRouteData;
import it.uiip.airport.facades.data.CabinCrewData;
import it.uiip.airport.facades.data.CrewData;
import it.uiip.airport.storefront.controllers.ControllerConstants;

@Controller
@RequestMapping(value = "/airport")
public class AirportController extends AbstractPageController
{
	@Resource(name = "airportFacade")
	private AirportFacade airportFacade;
	@Resource(name = "airportTicketFacade")
	private AirportTicketFacade ticketFacade;
	@Resource(name = "airportRouteFacade")
	private AirportRouteFacade routeFacade;

	private static final Logger LOG = Logger.getLogger(AirportController.class);



	@RequestMapping(value = "/search/{city}", method = RequestMethod.GET)
	public String searchAirportByCity(@PathVariable("city")
	final String city, final Model model, final HttpServletResponse response)
	{
		final List<AirportData> airports = airportFacade.getAirportsforCity(city);
		if (airports == null)
		{
			LOG.info("Lists of Airport null");
		}
		model.addAttribute("airports", airports);
		return ControllerConstants.Views.Pages.Airport.AirportSearchPage;

	}



	@RequestMapping(value = "/infoFlight/{codeRoute}", method = RequestMethod.GET)

	public String viewInfoFlight(@PathVariable("codeRoute")

	final String codeRoute, final Model model, final HttpServletResponse response)
	{
		final List<AirportRouteData> routes = routeFacade.getRoutesForCode(codeRoute);
		if (routes == null)
		{
			LOG.info("Lists of routes null");
		}
		model.addAttribute("route", routes.get(0));
		return ControllerConstants.Views.Pages.Airport.AirportInfoPage;

	}
	
	@RequestMapping(value = "/searchRoute/cabinCrew/{airportDep}", method = RequestMethod.GET)

	public String searchCabinCrewByAirportDep(@PathVariable("airportDep")

	final String airportDep, final Model model, final HttpServletResponse response)
	{
		final List<AirportRouteData> routes = routeFacade.getRoutesForAirportDep(airportDep);
		final AirportData airportDeparture = airportFacade.getAirportForCode(airportDep);

		if (routes == null)
		{
			LOG.info("Lists of routes null");
		}
		HashMap<String,List<CabinCrewData>> cabinCrewes = new HashMap<String,List<CabinCrewData>>();
		
		for (AirportRouteData route : routes) {
			AirportData airportArrival= route.getFlight().getAirportArr();
			CrewData crew = route.getCrew();
			cabinCrewes.put(route.getCodeRoute(),crew.getCabinCrew());
			model.addAttribute("airportArrival",airportArrival);
		}
		model.addAttribute("airportDeparture", airportDeparture);
		model.addAttribute("cabinCrewes", cabinCrewes);
		return ControllerConstants.Views.Pages.Airport.CabinCrewesPage;

	}
	
	@RequestMapping(value = "/searchRoute/commander/{commander}/{month}", method = RequestMethod.GET)

	public String searchRouteByCommander(@PathVariable("commander")final String commander,
			@PathVariable("month") final String month,
			final Model model, final HttpServletResponse response)
	{
		final List<AirportRouteData> routes = routeFacade.getRoutesForCommander(commander,month);
		if (routes == null)
		{
			LOG.info("Lists of routes null");
		}
		
		model.addAttribute("routes", routes);
		model.addAttribute("commander",commander);
		model.addAttribute("month",month);
		return ControllerConstants.Views.Pages.Airport.CommanderRoutePage;

	}
	
	
	
	

}
