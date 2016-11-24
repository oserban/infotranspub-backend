package ro.gov.ithub.station;

import ro.gov.ithub.entity.Agency;

import java.util.List;

public interface StationService {

    List<Station> getStations();

    List<Station> getStationsByAgency(Agency agency);

}
