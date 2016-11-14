package ro.gov.ithub.agency;

import org.springframework.stereotype.Service;
import ro.gov.ithub.city.City;

import java.util.ArrayList;
import java.util.List;

@Service
public class AgencyServiceImpl implements AgencyService {

    private static final List<Agency> ALL_AGENCIES;
    static {
        ALL_AGENCIES = new ArrayList<>();
        ALL_AGENCIES.add(createAgency(1, "RATUC", 1));
        ALL_AGENCIES.add(createAgency(2, "TFG", 2));
        ALL_AGENCIES.add(createAgency(3, "RATB", 2));
        ALL_AGENCIES.add(createAgency(4, "Transport-me", 3));
        ALL_AGENCIES.add(createAgency(5, "Ia-ma nene", 3));
        ALL_AGENCIES.add(createAgency(6, "Nashoo", 3));
    }

    private static Agency createAgency(int agencyId, final String agencyName,
                                       final int cityId) {
        Agency agency = new Agency(agencyId, agencyName);

        City correspondingCity = new City();
        correspondingCity.setId(cityId);
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
                    && (cityOfAgency.getId()==city.getId())) {
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
