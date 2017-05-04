package spring.model;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import spring.model.pojo.TripEntity;

import java.util.*;

/**
 * Created by Rage on 04.05.2017.
 */
public class TripDaoImpl implements TripDao {

    private SessionFactory mSessionFactory;

    public TripDaoImpl(SessionFactory sessionFactory) {
        mSessionFactory = sessionFactory;
    }

    @Override
    public void insertTrip(TripEntity tripEntity) {
        mSessionFactory.openSession().save(tripEntity);
    }

    @Override
    public void deleteTrip(int id) {
        Session session=mSessionFactory.openSession();
        TripEntity tripEntity = session.load(TripEntity.class,id);
        session.delete(tripEntity);
        session.flush();
    }

    @Override
    public List<TripEntity> getAllTrip() {
        return mSessionFactory.openSession().createQuery("from TripEntity").list();
    }

    @Override
    public Set<TripEntity> searchTripEntity(int depCity, int arrCity, int depCountry, int arrCountry) {
        Set<TripEntity> searchResult = new HashSet<>();
        List<TripEntity> tripCityEntityList;
        List<TripEntity> tripCountryEntityList;
        String pred;
        if (depCity != -1 && arrCity != -1) {
            pred = "and";
        } else if (depCity == -1 && arrCity == -1) {
            pred = null;
        } else {
            pred = "or";
        }
        if (pred != null) {
            tripCityEntityList = mSessionFactory.openSession().createQuery("from TripEntity where tripDeparture=? " + pred + " tripArrival=?")
                    .setInteger(0, depCity).setInteger(1, arrCity).list();
            if(tripCityEntityList!=null && !tripCityEntityList.isEmpty()){
                searchResult.addAll(tripCityEntityList);
            }
        }

        if (depCountry != -1 && arrCountry != -1) {
            pred = "and";
        } else if (depCountry == -1 && arrCountry == -1) {
            pred = null;
        } else {
            pred = "or";
        }
        if(pred!=null) {
            tripCountryEntityList = mSessionFactory.openSession().createQuery("from TripEntity where tableCityDepartureEntity.countryId=? "+pred+" tableCityArrivalEntity.countryId=?")
                    .setInteger(0, depCountry).setInteger(1, arrCountry).list();
            if(tripCountryEntityList!=null && !tripCountryEntityList.isEmpty()){
                searchResult.addAll(tripCountryEntityList);
            }
        }
        return searchResult;
    }
}
