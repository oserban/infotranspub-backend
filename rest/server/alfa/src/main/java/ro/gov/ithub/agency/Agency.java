package ro.gov.ithub.agency;

import lombok.Data;
import lombok.NoArgsConstructor;
import ro.gov.ithub.base.BaseEntity;
import ro.gov.ithub.city.City;
import ro.gov.ithub.station.Station;

import javax.persistence.*;
import java.util.List;

import static ro.gov.ithub.base.BaseEntity.SCHEMA_NAME;

/**
 * Created by Mihnea on 11/12/16.
 */
@Data
@NoArgsConstructor
@Entity
@Table
public class Agency implements BaseEntity {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Access(AccessType.PROPERTY)
    private Integer id;

    @Column(nullable = false)
    private String agencyName;

    @ManyToOne(fetch = FetchType.EAGER)
    private City city;

    @OneToMany(fetch = FetchType.EAGER)
    private List<Station> stations;

    public Agency(final Integer agencyId,
                  final String agencyName) {
        this.id = agencyId;
        this.agencyName = agencyName;
    }

    @Override
    public String toString() {
        return GSON.toJson(this);
    }
}
