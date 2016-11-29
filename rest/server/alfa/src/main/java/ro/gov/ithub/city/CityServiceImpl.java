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
    public City getCityWithAgencies(String cityName) {

        for (City c: cityRepository.findAll()) {
            if(StringUtils.equalsIgnoreCase(cityName, c.getCityUrl())) {
                c.setAgencies(agencyService.getAgenciesForCity(c));
                return c;
            }
        }

        return null;
    }

}
