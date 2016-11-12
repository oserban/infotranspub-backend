package ro.gov.ithub.cities;

import com.google.gson.Gson;
import lombok.Data;
import lombok.NoArgsConstructor;
import ro.gov.ithub.base.BaseEntity;

@Data
@NoArgsConstructor
public class City implements BaseEntity {

    private static final Gson GSON = new Gson();

    private int id;
    private String name;

    public City(int cityId, String cityName) {
        this.id = cityId;
        this.name = cityName;
    }

    public City(String cityName) {
        this.name = cityName;
    }

    @Override
    public String toString() {
        String json = GSON.toJson(this);
        return json;

    }

}


