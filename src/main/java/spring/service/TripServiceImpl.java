package spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import spring.model.TripDao;
import spring.model.pojo.CityEntity;
import spring.model.pojo.CountryEntity;
import spring.model.pojo.TripEntity;

import java.util.List;
import java.util.Set;

/**
 * Created by Rage on 04.05.2017.
 */
public class TripServiceImpl implements TripService {

    private TripDao mTripDao;

    public TripServiceImpl(TripDao tripDao) {
        mTripDao = tripDao;
    }

    @Override
    @Transactional
    public void addTrip(TripEntity tripEntity) {
        mTripDao.insertTrip(tripEntity);
    }

    @Override
    @Transactional
    public void deleteTrip(int id) {
        mTripDao.deleteTrip(id);
    }

    @Override
    public List<TripEntity> getAllTrip() {
        return mTripDao.getAllTrip();
    }

    @Override
    public Set<TripEntity> searchTripEntity(int depCity, int arrCity, int depCountry, int arrCountry) {
        return mTripDao.searchTripEntity(depCity,arrCity,depCountry,arrCountry);
    }

    public static void main(String[] args) {
        System.out.println(42%10);
    }


}
