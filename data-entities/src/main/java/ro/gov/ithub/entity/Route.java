package ro.gov.ithub.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import ro.gov.ithub.base.BaseEntity;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
@Table
@EqualsAndHashCode(of = {"routeId", "routeShortName"})
@ToString(exclude="agency")
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

    // TODO create an enum according to the route types
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
