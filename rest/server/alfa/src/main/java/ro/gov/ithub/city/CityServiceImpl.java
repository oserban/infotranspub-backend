package ro.gov.ithub.city;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.gov.ithub.agency.AgencyService;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

@Service
public class CityServiceImpl implements CityService {

    @Autowired
    private AgencyService agencyService;

    private static Map<String, City> ALL_CITIES;
    static {
        List<City> cities = new ArrayList<>();
        cities.add(new City("ro_bh_oradea", "Oradea"));
        cities.add(new City("ro_cj_clujnapoca", "Cluj"));
        cities.add(new City("ro_bucharest", "Bucuresti"));
        cities.add(new City("ro_tm_timisoara", "Timisoara"));
        cities.add(new City("ro_is_iasi", "Iasi"));

        for(City city : cities) {
            ALL_CITIES.put(city.getId(), city);
        }
    }

    @Override
    public Collection<City> getCities() {
        if(ALL_CITIES == null) {
            return new ArrayList<>();
        }
        return ALL_CITIES.values();
    }

    @Override
    public City getCityWithAgencies(String cityName) {

        for (City c: ALL_CITIES.values()) {
            if(StringUtils.equalsIgnoreCase(cityName, c.getId())) {
                c.setAgencies(agencyService.getAgenciesForCity(c));
                return c;
            }
        }

        return null;
    }

}
