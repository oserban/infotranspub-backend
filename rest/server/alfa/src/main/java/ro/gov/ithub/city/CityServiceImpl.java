package ro.gov.ithub.city;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.gov.ithub.agency.AgencyService;

import java.util.ArrayList;
import java.util.List;

@Service
public class CityServiceImpl implements CityService {

    @Autowired
    private AgencyService agencyService;

    private static final List<City> ALL_CITIES;
    static {
        ALL_CITIES = new ArrayList<>();
        ALL_CITIES.add(new City(1, "Oradea"));
        ALL_CITIES.add(new City(2, "Cluj"));
        ALL_CITIES.add(new City(3, "Bucuresti"));
        ALL_CITIES.add(new City(4, "Timisoara"));
        ALL_CITIES.add(new City(5, "Iasi"));
    }

    @Override
    public List<City> getCities() {
        if(ALL_CITIES == null) {
            return new ArrayList<>();
        }
        return ALL_CITIES;
    }

    @Override
    public City getCityWithAgencies(String cityName) {

        for (City c: ALL_CITIES) {
            if(StringUtils.equalsIgnoreCase(cityName, c.getName())) {
                c.setAgencies(agencyService.getAgenciesForCity(c));
                return c;
            }
        }

        return null;
    }

}
