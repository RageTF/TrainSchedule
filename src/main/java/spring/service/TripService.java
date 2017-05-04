package spring.service;

import spring.model.pojo.CityEntity;
import spring.model.pojo.CountryEntity;
import spring.model.pojo.TripEntity;

import java.util.List;
import java.util.Set;

/**
 * Created by Rage on 04.05.2017.
 */
public interface TripService {

    void addTrip(TripEntity tripEntity);
    void deleteTrip(int id);

    List<TripEntity> getAllTrip();

    Set<TripEntity> searchTripEntity(int depCity, int arrCity, int depCountry, int arrCountry);

}
