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
    private Integer id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String url;

    @Column(nullable = false)
    private String timezone;

    @Column
    private String lang;

    @Column
    private String phone;

    @Column
    private String fareUrl;
    
    @Column
    private String email;

    @OneToMany(fetch = FetchType.EAGER)
    private Set<Route> routes;

    @Override
    public String toString() {
        return GSON.toJson(this);
    }
}
