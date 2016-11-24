package ro.gov.ithub.station;

import lombok.Data;
import lombok.NoArgsConstructor;
import ro.gov.ithub.entity.Agency;
import ro.gov.ithub.base.BaseEntity;
import ro.gov.ithub.city.City;

import javax.persistence.*;

/**
 * Created by Mihnea on 11/12/16.
 */
@Data
@NoArgsConstructor
@Entity
@Table
public class Station implements BaseEntity {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Access(AccessType.PROPERTY)
    private Integer id;

    @Column(nullable = false)
    private String stationName;

    @ManyToOne(fetch = FetchType.LAZY)
    private City city;

    @ManyToOne(fetch = FetchType.LAZY)
    private Agency agency;

    public Station(final Integer stationId,
                   final String stationName) {
        this.id = stationId;
        this.stationName = stationName;
    }

    @Override
    public String toString() {
        return GSON.toJson(this);
    }
}
