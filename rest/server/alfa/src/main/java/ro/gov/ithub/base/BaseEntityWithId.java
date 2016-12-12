package ro.gov.ithub.base;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@MappedSuperclass
public class BaseEntityWithId implements BaseEntity, Serializable {

    @Id
    @Column(updatable = false, nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Access(value = AccessType.PROPERTY)
    private Integer id;
}
