package ro.gov.ithub.agency;

import ro.gov.ithub.city.City;

import java.util.List;

public interface AgencyService {

    List<Agency> getAllAgencies();

    List<Agency> getAgenciesForCity(City city);

    List<Agency> getAgenciesWithStationsForCity(City city);
}
