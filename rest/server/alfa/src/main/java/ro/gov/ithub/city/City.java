package ro.gov.ithub.city;

import lombok.Data;
import lombok.NoArgsConstructor;
import ro.gov.ithub.entity.Agency;
import ro.gov.ithub.base.BaseEntity;
import ro.gov.ithub.station.Station;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
@Table
public class City implements BaseEntity {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Access(AccessType.PROPERTY)
    private Integer cityId;

    @Column(nullable = false, unique = true)
    private String cityUrl;

    @OneToMany
    private List<Agency> agencies;

    @OneToMany
    private List<Station> stations;

    public City(String cityNaturalId) {
        this.cityUrl = cityNaturalId;
    }

    @Override
    public String toString() {
        return GSON.toJson(this);
    }

}


