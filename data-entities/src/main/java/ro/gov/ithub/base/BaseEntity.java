package ro.gov.ithub.base;

import com.google.gson.Gson;

import java.io.Serializable;

public interface BaseEntity extends Serializable {

    Gson GSON = new Gson();

}
