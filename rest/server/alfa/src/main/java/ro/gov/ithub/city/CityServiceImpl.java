package ro.gov.ithub.city;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CityServiceImpl implements CityService {

    private static final List<City> ALL_CITIES;
    static {
        ALL_CITIES = new ArrayList<>();
        ALL_CITIES.add(new City(1, "Oradea"));
        ALL_CITIES.add(new City(2, "Cluj-Napoca"));
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

}
