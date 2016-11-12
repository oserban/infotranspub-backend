package ro.gov.ithub.cities;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ro.gov.ithub.base.BaseController;

import java.util.*;

@RestController
public class CityController extends BaseController<City> {


	@RequestMapping("/cities")
	public List<City> getAllCities() {
		return getHardcodedCityList();
	}

	private List<City> getHardcodedCityList() {
		List<City>  list = new ArrayList<>();
		list.add(new City(1, "Bucuresti"));
		list.add(new City(2, "Cluj-Napoca"));
		list.add(new City(3, "Oradea"));
		list.add(new City(4, "Iasi"));
		list.add(new City(5, "Timisoara"));
		return list;
	}
}
