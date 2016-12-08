package ro.gov.ithub.city;

import ro.gov.ithub.base.BaseRepository;

/**
 * Created by Mihnea on 11/23/16.
 */
public interface CityRepository extends BaseRepository<City, Integer> {

    City findCityByCityShortName(String shortName);

}
