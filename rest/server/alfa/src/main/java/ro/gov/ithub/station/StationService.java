package ro.gov.ithub.station;

import ro.gov.ithub.agency.Agency;
import ro.gov.ithub.city.City;

import java.util.List;

public interface StationService {

    List<Station> getStations();

    List<Station> getStationsByAgency(Agency agency);

}
