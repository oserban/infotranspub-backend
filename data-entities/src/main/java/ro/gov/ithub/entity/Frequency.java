package ro.gov.ithub.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import ro.gov.ithub.base.BaseEntity;
import ro.gov.ithub.entity.util.FrequencyExactTimes;

import javax.persistence.*;
import java.util.Date;

@Data
@NoArgsConstructor
@Entity
@Table
@EqualsAndHashCode(of = {"frequencyId", "tripId"})
public class Frequency implements BaseEntity {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Access(AccessType.PROPERTY)
    private Integer frequencyId;

    @Column(nullable = false)
    private Integer tripId;

    @Column(nullable = false)
    private Date startTime;

    @Column(nullable = false)
    private Date stopTime;

    @Column(nullable = false)
    private Integer headwaySecs;

    @Enumerated
    private FrequencyExactTimes exactTimes;

    @Override
    public String toString() {
        return GSON.toJson(this);
    }
}
