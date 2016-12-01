package ro.gov.ithub.base;

import com.google.gson.Gson;

import java.io.Serializable;

/**
 * Created by Mihnea on 11/10/16.
 */
public interface BaseEntity extends Serializable {

    Gson GSON = new Gson();

}
