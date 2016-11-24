package ro.gov.ithub.station;

import org.springframework.stereotype.Service;
import ro.gov.ithub.entity.Agency;

import java.util.ArrayList;
import java.util.List;

@Service
public class StationServiceImpl implements StationService {

    private static final List<Station> ALL_STATIONS;

    static {
        ALL_STATIONS = new ArrayList<>();
        ALL_STATIONS.add(createStation(1, "Marasti", 1));
        ALL_STATIONS.add(createStation(2, "Marasesti", 2));
        ALL_STATIONS.add(createStation(3, "Oituz", 2));
        ALL_STATIONS.add(createStation(4, "Iulius Est", 3));
        ALL_STATIONS.add(createStation(5, "Iulius Nord", 3));
        ALL_STATIONS.add(createStation(6, "Decebal", 3));
        ALL_STATIONS.add(createStation(7, "Regionala", 4));
        ALL_STATIONS.add(createStation(8, "Opera", 4));
        ALL_STATIONS.add(createStation(9, "Unirii", 4));
        ALL_STATIONS.add(createStation(10, "Centru", 4));
        ALL_STATIONS.add(createStation(11, "Laguna", 5));
        ALL_STATIONS.add(createStation(12, "Kios", 5));
    }

    private static Station createStation(int stationId,
                                         String stationName,
                                         int agencyId) {
        Agency agency = new Agency();
        agency.setAgencyId(agencyId);

        Station station = new Station(stationId, stationName);
        station.setAgency(agency);

        return station;
    }

    @Override
    public List<Station> getStations() {
        if (ALL_STATIONS == null) {
            return new ArrayList<>();
        }
        return ALL_STATIONS;
    }

    @Override
    public List<Station> getStationsByAgency(Agency agency) {
        List<Station> stationsOfAgency = new ArrayList<>();

        for (Station s : getStations()) {
            Agency agencyOfStation = s.getAgency();
            if (agencyOfStation != null && agencyOfStation.getAgencyId() == agency.getAgencyId()) {
                stationsOfAgency.add(s);
            }
        }
        return stationsOfAgency;
    }

}
