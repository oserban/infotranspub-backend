package ro.gov.ithub.agency.station;

import lombok.Data;
import lombok.NoArgsConstructor;
import ro.gov.ithub.base.BaseEntity;
import ro.gov.ithub.city.City;
import ro.gov.ithub.station.Station;

import java.util.List;

/**
 * Created by Mihnea on 11/12/16.
 */
@Data
@NoArgsConstructor
public class Agency implements BaseEntity {

    private int id;
    private String name;
    private City city;
    private List<Station> stations;

    public Agency(int agencyId,
                  String agencyName) {
        this.id = agencyId;
        this.name = agencyName;
    }

    @Override
    public String toString() {
        return GSON.toJson(this);
    }
}
