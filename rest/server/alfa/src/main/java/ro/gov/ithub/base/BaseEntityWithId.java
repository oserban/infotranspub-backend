package ro.gov.ithub.base;

import com.google.gson.Gson;

import javax.persistence.*;
import java.io.Serializable;

public class BaseEntityWithId implements Serializable {

    private static final Gson GSON = new Gson();

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Access(AccessType.PROPERTY)
    private Integer id;
}
