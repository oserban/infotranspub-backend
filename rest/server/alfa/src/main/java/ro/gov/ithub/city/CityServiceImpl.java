package ro.gov.ithub.city;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CityServiceImpl implements CityService {

    @Override
    public List<City> getHardcodedCities() {
        List<City>  list = new ArrayList<>();
        list.add(new City(1, "Oradea"));
        list.add(new City(2, "Cluj-Napoca"));
        list.add(new City(3, "Bucuresti"));
        list.add(new City(4, "Timisoara"));
        list.add(new City(5, "Iasi"));
        return list;
    }

}
