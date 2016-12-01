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
public class FareRule implements BaseEntity {

    static final String TABLE_NAME = "FARE_RULE";

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Access(AccessType.PROPERTY)
    private Integer fareId;

    @ManyToOne
    private Route route;

//    TODO map these to stops
    @Column
    private Integer originId;
    @Column
    private Integer destinationId;

//    TODO clarify zones
    @Column
    private Integer containsId;

    @OneToMany
    private List<FareAttribute> fareAttributes;

    @Override
    public String toString() {
        return GSON.toJson(this);
    }
}
