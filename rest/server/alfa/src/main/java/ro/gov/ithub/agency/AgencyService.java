package ro.gov.ithub.agency;

import ro.gov.ithub.city.City;
import ro.gov.ithub.entity.Agency;

import java.util.List;
import java.util.Set;

public interface AgencyService {

    Set<Agency> getAllAgencies();

    Set<Agency> getAgenciesForCity(City city);

    Set<Agency> getAgenciesWithStationsForCity(City city);
}
