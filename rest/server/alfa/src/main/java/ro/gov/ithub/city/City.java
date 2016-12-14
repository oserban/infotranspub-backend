package ro.gov.ithub.city;

import lombok.Data;
import lombok.NoArgsConstructor;
import ro.gov.ithub.base.BaseEntity;
import ro.gov.ithub.entity.Agency;

import javax.persistence.*;
import java.util.Set;

@Data
@NoArgsConstructor
@Entity
@Table
public class City implements BaseEntity {

    static final String TABLE_NAME = "CITY";

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Access(AccessType.PROPERTY)
    private Integer cityId;

    @Column(nullable = false, unique = true)
    private String cityUrl;

    @OneToMany
    private Set<Agency> agencies;

    @Override
    public String toString() {
        return GSON.toJson(this);
    }

}


