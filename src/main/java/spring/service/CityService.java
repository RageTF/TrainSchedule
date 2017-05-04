package spring.service;

import spring.model.pojo.CityEntity;

import java.util.List;

/**
 * Created by Rage on 04.05.2017.
 */
public interface CityService {

    void addCity(CityEntity cityEntity);
    void deleteCity(int id);
    List<CityEntity> getAllCity();
    int getCityId(String name);

}
