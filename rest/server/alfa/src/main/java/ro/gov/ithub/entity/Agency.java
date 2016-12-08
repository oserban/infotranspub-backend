package ro.gov.ithub.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import ro.gov.ithub.base.BaseEntity;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by Mihnea on 11/12/16.
 */
@Data
@NoArgsConstructor
@Entity
@Table
public class Agency implements BaseEntity {

    static final String TABLE_NAME = "AGENCY";
    public static final String COLUMN_CITY_ID = "CITY_ID";

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
    private String agencyTimezone;

    @Column
    private String agencyLang;

    @Column
    private String agencyPhone;

    @OneToMany(fetch = FetchType.EAGER)
    private Set<Route> routes;

    @Override
    public String toString() {
        return GSON.toJson(this);
    }
}
