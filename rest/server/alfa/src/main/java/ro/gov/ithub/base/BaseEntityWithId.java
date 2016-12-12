package ro.gov.ithub.base;

import com.google.gson.Gson;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
public class BaseEntityWithId implements Serializable {

    protected static final Gson GSON = new Gson();

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Access(AccessType.PROPERTY)
    private Integer id;
}
