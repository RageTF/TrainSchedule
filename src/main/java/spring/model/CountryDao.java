package spring.model;

import spring.model.pojo.CountryEntity;
import spring.model.pojo.TripEntity;
import spring.model.pojo.UsersEntity;

import java.util.List;

/**
 * Created by Rage on 03.05.2017.
 */
public interface CountryDao {

    int insertCountry(CountryEntity countryEntity);
    void deleteCountry(int id);
    List<CountryEntity> getAllCountries();
    int getCountryIdByName(String country);

}
