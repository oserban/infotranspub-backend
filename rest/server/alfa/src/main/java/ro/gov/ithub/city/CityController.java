package ro.gov.ithub.city;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ro.gov.ithub.base.BaseController;
import ro.gov.ithub.entity.Agency;

import java.util.Collection;
import java.util.Set;

@RestController
public class CityController extends BaseController<City> {

	@Autowired
	private CityService cityService;

	@RequestMapping(
			value = { "/citylist", "/listaorase" },
			method = RequestMethod.GET)
	public Collection<City> getAllCities() {
		return cityService.getCities();
	}

	@RequestMapping(
			value = { "/city/{cityName}", "/oras/{cityName}" },
			method = RequestMethod.GET)
	public City getCity(@PathVariable("cityName") final String cityName) {
		return cityService.getCityWithAgencies(cityName);
	}

	@RequestMapping(
			value = { "/city/{cityName}", "/oras/{cityName}" },
			method = RequestMethod.POST)
	public void saveOrUpdateCity(@PathVariable("cityName") final City cityName) {
		cityService.saveOrUpdateCity(cityName);
	}


	@RequestMapping(
			value = { "/city/{cityName}/agencylist", "/oras/{cityName}/listaregii/" },
			method = RequestMethod.GET)
	public City getAgenciesForCity(@PathVariable("cityName") final String cityName) {
		return cityService.getCityWithAgencies(cityName);
	}
}
