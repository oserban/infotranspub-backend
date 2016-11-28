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
public class Route implements BaseEntity {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Access(AccessType.PROPERTY)
    private Integer routeId;

    @ManyToOne
    private Agency agency;

    @Column(nullable = false)
    private String routeShortName;

    @Column(nullable = false)
    private String routeLongName;

    @Column
    private String routeDesc;

    // TODO what are the route types ?
    @Column
    private String routeType;

    @Column
    private String routeUrl;

    @Column
    private String routeColor;

    @Column
    private String routeTextColor;

    @OneToMany
    private List<FareRule> fareRules;

//    TODO trips

    @Override
    public String toString() {
        return GSON.toJson(this);
    }
}
