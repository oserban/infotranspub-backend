package ro.gov.ithub.city;

import java.util.List;

public interface CityService {

    List<City> getCities();

    City getCityWithAgencies(String cityName);
}
