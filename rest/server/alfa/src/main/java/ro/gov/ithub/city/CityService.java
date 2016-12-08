package ro.gov.ithub.city;

import java.util.Collection;

public interface CityService {

    Collection<City> getCities();

    City getCityWithAgencies(String cityName);

    void saveCity(City city);

    void delete(City city);
}
