package spring.service;

import org.springframework.transaction.annotation.Transactional;
import spring.model.CityDao;
import spring.model.pojo.CityEntity;

import java.util.List;

/**
 * Created by Rage on 04.05.2017.
 */
public class CityServiceImpl implements CityService {

    private CityDao mCityDao;

    public CityServiceImpl(CityDao cityDao) {
        mCityDao = cityDao;
    }

    @Override
    @Transactional
    public void addCity(CityEntity cityEntity) {
        mCityDao.insertCity(cityEntity);
    }

    @Override
    @Transactional
    public void deleteCity(int id) {
        mCityDao.deleteCity(id);
    }

    @Override
    public List<CityEntity> getAllCity() {
        return mCityDao.getAllCities();
    }

    @Override
    public int getCityId(String name) {
        return mCityDao.getCityIdByName(name);
    }
}
