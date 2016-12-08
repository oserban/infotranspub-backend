package ro.gov.ithub.city;

import ro.gov.ithub.base.BaseService;

public interface CityService extends BaseService<City, Integer> {

    City findByCityName(String cityName);

    void delete(City city);
}
