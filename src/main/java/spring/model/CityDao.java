package spring.model;

import spring.model.pojo.CityEntity;

import java.util.List;

/**
 * Created by Rage on 04.05.2017.
 */
public interface CityDao {

    void insertCity(CityEntity cityEntity);
    void deleteCity(int id);
    List<CityEntity> getAllCities();
    int getCityIdByName(String city);

}
