package ro.gov.ithub.city;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ro.gov.ithub.agency.Agency;
import ro.gov.ithub.base.BaseController;

import java.util.*;

@RestController
public class CityController extends BaseController<City> {

	@Autowired
	private CityService cityService;

	@RequestMapping(value = "/citylist", method = RequestMethod.GET)
	public Collection<City> getAllCities() {
		return cityService.getCities();
	}

	@RequestMapping(value = "/citylist/{cityName}", method = RequestMethod.GET)
	public City getCity(@PathVariable("cityName") final String cityName) {
		return cityService.getCityWithAgencies(cityName);
	}

	@RequestMapping(value = "/citylist/{cityName}/agencylist", method = RequestMethod.GET)
	public List<Agency> getAgenciesForCity(@PathVariable("cityName") final String cityName) {
		return cityService.getCityWithAgencies(cityName).getAgencies();
	}
}
