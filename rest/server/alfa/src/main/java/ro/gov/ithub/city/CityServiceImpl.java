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
    public City getCityWithAgencies(String cityUrl) {
        return cityRepository.findCityByCityUrl(cityUrl);
    }

    @Override
    public void saveOrUpdateCity(City city) {
        if (city.getCityId() == null) {
            this.cityRepository.save(city);
        } else {
            this.cityRepository.update(city);
        }
    }

}
