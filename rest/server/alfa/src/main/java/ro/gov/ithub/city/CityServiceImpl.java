package ro.gov.ithub.city;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ro.gov.ithub.agency.AgencyService;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

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

        City result = cityRepository.findCityByCityUrl(cityUrl);
        if (result == null) {
            System.out.println("FIND NOT WORKING");
        } else {
            return result;
        }

        result = cityRepository.getCityByCityUrl(cityUrl);
        if (result == null) {
            System.out.println("GET NOT WORKING");
        } else {
            return result;
        }


        for (City c : cityRepository.findAll()) {
            if (StringUtils.equalsIgnoreCase(cityUrl, c.getCityUrl())) {
                c.setAgencies(agencyService.getAgenciesForCity(c));
                return c;
            }
        }

        return null;
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
