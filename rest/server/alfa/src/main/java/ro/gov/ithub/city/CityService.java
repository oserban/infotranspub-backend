package ro.gov.ithub.city;

import java.util.Collection;
import java.util.List;

public interface CityService {

    Collection<City> getCities();

    City getCityWithAgencies(String cityName);

}
