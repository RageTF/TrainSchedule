package spring.model;

import spring.model.pojo.CityEntity;
import spring.model.pojo.TripEntity;

import java.util.Date;
import java.util.List;
import java.util.Set;

/**
 * Created by Rage on 04.05.2017.
 */
public interface TripDao {

    void insertTrip(TripEntity tripEntity);
    void deleteTrip(int id);
    List<TripEntity> getAllTrip();
    Set<TripEntity> searchTripEntity(int depCity, int arrCity, int depCountry, int arrCountry);

}
