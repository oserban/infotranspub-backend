package ro.gov.ithub.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import ro.gov.ithub.base.BaseEntity;

import javax.persistence.*;
import java.util.Date;

@Data
@NoArgsConstructor
@Entity
@Table
@EqualsAndHashCode(of={"stopId"})
public class Stoptime implements BaseEntity {

    static final String TABLE_NAME = "STOPTIME";
    static final String COLUMN_TRIP_ID = "TRIP_ID";
    static final String COLUMN_STOP_ID = "STOP_ID";

    @Id
    @Column
    @Access(AccessType.PROPERTY)
    private Integer stopId;

    @ManyToOne
    private Trip trips;

    @Column(nullable = false)
    private Date arrivalTime;

    @Column(nullable = false)
    private Date departureTime;

    @MapsId
    @OneToOne
    @PrimaryKeyJoinColumn
    private Stop stop;

//    TODO stop IMPL [1]
//TODO   clarify the rest of the parameters
//    stopSequence [1]
//    stopHeadsign [0..1]
//    pickupType [0..1]
//    dropOffType [0..1]
//    shapeDistTraveled [0..1]

    @Override
    public String toString() {
        return GSON.toJson(this);
    }
}
