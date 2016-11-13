package ro.gov.ithub.station;

import lombok.Data;
import lombok.NoArgsConstructor;
import ro.gov.ithub.agency.station.Agency;
import ro.gov.ithub.base.BaseEntity;
import ro.gov.ithub.city.City;

/**
 * Created by Mihnea on 11/12/16.
 */
@Data
@NoArgsConstructor
public class Station implements BaseEntity {

    private int id;
    private String name;
    private City city;
    private Agency agency;

    public Station(int stationId,
                   String stationName) {
        this.id = stationId;
        this.name = stationName;
    }

    @Override
    public String toString() {
        return GSON.toJson(this);
    }
}
