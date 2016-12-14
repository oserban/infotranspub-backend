package ro.gov.ithub.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import ro.gov.ithub.base.BaseEntity;
import ro.gov.ithub.entity.util.StopLocationType;
import ro.gov.ithub.entity.util.WheelchairAccessible;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by Mihnea on 11/12/16.
 */
@Data
@NoArgsConstructor
@Entity
@Table
public class Stop implements BaseEntity {

    static final String TABLE_NAME = "STOP";
    static final String COLUMN_STOP_ID = "STOP_ID";
    static final String COLUMN_PARENT_STATION = "PARENT_STATION";

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Access(AccessType.PROPERTY)
    private Integer stopId;

    @Column
    private Integer stopCode;

    @Column(nullable = false)
    private String stopName;

    @Column
    private String stopDesc;

    @Column(nullable = false)
    private Double stopLat;

    @Column(nullable = false)
    private Double stopLong;

    @Column
    private Integer zoneId;

    @Column
    private String stopUrl;

    @Enumerated
    private StopLocationType locationType;

    @ManyToOne
    @JoinColumn(name = Stop.COLUMN_PARENT_STATION)
    private Stop parentStation;

    @OneToMany(mappedBy = "parentStation")
    private Set<Stop> childStations;

    @ManyToMany
    @JoinTable(name = Transfer.TABLE_NAME,
            joinColumns = { @JoinColumn(name = Transfer.COLUMN_FROM_STOP_ID,
                                        insertable = false,
                                        updatable = false ) },
            inverseJoinColumns = { @JoinColumn(name = Transfer.COLUMN_TO_STOP_ID,
                                                insertable = false,
                                                updatable = false ) })
    private Set<Stop> transferStops;

    @OneToOne(cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn(name = Stop.COLUMN_STOP_ID,
            referencedColumnName = Stoptime.COLUMN_STOP_ID)
    private Stoptime stoptime;

    @Enumerated
    private WheelchairAccessible wheelchairBoarding;

    @Override
    public String toString() {
        return GSON.toJson(this);
    }
}
