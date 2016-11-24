package ro.gov.ithub.agency;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.gov.ithub.city.City;
import ro.gov.ithub.entity.Agency;

import java.util.ArrayList;
import java.util.List;

@Service
public class AgencyServiceImpl implements AgencyService {

    @Autowired
    private AgencyRepository agencyRepository;

    private static final List<Agency> ALL_AGENCIES;
    static {
        ALL_AGENCIES = new ArrayList<>();
        ALL_AGENCIES.add(createAgency(1, "RATUC", "ro_cj_cluj"));
        ALL_AGENCIES.add(createAgency(2, "TFG", "ro_cj_cluj"));
        ALL_AGENCIES.add(createAgency(3, "RATB", "ro_cj_cluj"));
        ALL_AGENCIES.add(createAgency(4, "Transport-me", "ro_is_iasi"));
        ALL_AGENCIES.add(createAgency(5, "Ia-ma nene", "ro_is_iasi"));
        ALL_AGENCIES.add(createAgency(6, "Nashoo", "ro_is_iasi"));
    }

    private static Agency createAgency(int agencyId, final String agencyName,
                                       final String cityUrl) {
        Agency agency = new Agency();
        agency.setAgencyId(agencyId);
        agency.setAgencyName(agencyName);

        City correspondingCity = new City();
        correspondingCity.setCityUrl(cityUrl);
        agency.setCity(correspondingCity);

        return agency;
    }

    @Override
    public List<Agency> getAllAgencies() {
        if(ALL_AGENCIES==null) {
            return new ArrayList<>();
        }
        return ALL_AGENCIES;
    }

    @Override
    public List<Agency> getAgenciesForCity(City city) {
        ArrayList<Agency> agenciesForCity = new ArrayList<>();

        for (Agency a : ALL_AGENCIES) {
            City cityOfAgency = a.getCity();
            if((cityOfAgency != null)
                    && (cityOfAgency.getCityUrl()==city.getCityUrl())) {
                agenciesForCity.add(a);
            }
        }
        return agenciesForCity;
    }

    @Override
    public List<Agency> getAgenciesWithStationsForCity(City city) {
        List<Agency> agenciesForCity = getAgenciesForCity(city);

//        TODO initialize stationList

        return agenciesForCity;
    }
}
