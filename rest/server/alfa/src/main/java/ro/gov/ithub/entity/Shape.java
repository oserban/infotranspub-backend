package ro.gov.ithub.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import ro.gov.ithub.base.BaseEntity;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Mihnea on 11/12/16.
 */
@Data
@NoArgsConstructor
@Entity
@Table
public class Shape implements BaseEntity {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Access(AccessType.PROPERTY)
    private Integer shapeId;

//    TODO is there a value more proper than Double for these?
    @Column(nullable = false)
    private Double shapePtLat;

    @Column(nullable = false)
    private Double shapePtLon;

    @Column(nullable = false)
    private Double shapePtSequence;

    @Column
    private Double shapeDistTraveled;

    @ManyToMany
    private List<Trip> trips;

    @Override
    public String toString() {
        return GSON.toJson(this);
    }
}
