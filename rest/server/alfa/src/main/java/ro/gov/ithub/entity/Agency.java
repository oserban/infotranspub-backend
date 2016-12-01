package ro.gov.ithub.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import ro.gov.ithub.base.BaseEntity;
import ro.gov.ithub.city.City;

import javax.persistence.*;
import java.util.Set;
import java.util.TimeZone;

/**
 * Created by Mihnea on 11/12/16.
 */
@Data
@NoArgsConstructor
@Entity
@Table
public class Agency implements BaseEntity {

    static final String TABLE_NAME = "AGENCY";

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Access(AccessType.PROPERTY)
    private Integer agencyId;

    @Column(nullable = false)
    private String agencyName;

    @Column(nullable = false)
    private String agencyUrl;

    @Column(nullable = false)
    private TimeZone agencyTimezone;

    @Column
    private String agencyLang;

    @Column
    private String agencyPhone;

    @ManyToOne
    private City city;

    @OneToMany(fetch = FetchType.EAGER)
    private Set<Route> routes;

    @Override
    public String toString() {
        return GSON.toJson(this);
    }
}
