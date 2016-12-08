package ro.gov.ithub.city;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.gov.ithub.agency.AgencyService;

import java.util.Collection;

@Service
public class CityServiceImpl implements CityService {

    @Autowired
    private CityRepository cityRepository;

    @Autowired
    private AgencyService agencyService;

    @Override
    public Collection<City> getCities() {
        return this.cityRepository.findAll();
    }

    @Override
    public City getCityWithAgencies(String cityShortName) {
        return cityRepository.findCityByCityShortName(cityShortName);
    }

    @Override
    public void saveCity(City city) {
        this.cityRepository.save(city);
    }

    @Override
    public void delete(City city) {
        this.cityRepository.delete(city);
    }

}
