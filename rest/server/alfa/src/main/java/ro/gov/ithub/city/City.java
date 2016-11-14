package ro.gov.ithub.city;

import lombok.Data;
import lombok.NoArgsConstructor;
import ro.gov.ithub.agency.Agency;
import ro.gov.ithub.base.BaseEntity;
import ro.gov.ithub.station.Station;

import java.util.List;

@Data
@NoArgsConstructor
public class City implements BaseEntity {

    private int id;
    private String name;
    private List<Agency> agencies;
    private List<Station> stations;

    public City(int cityId, String cityName) {
        this.id = cityId;
        this.name = cityName;
    }

    public City(String cityName) {
        this.name = cityName;
    }

    @Override
    public String toString() {
        return GSON.toJson(this);
    }

}


