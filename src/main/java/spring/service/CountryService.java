package spring.service;

import spring.model.pojo.CountryEntity;

import java.util.List;

/**
 * Created by Rage on 04.05.2017.
 */
public interface CountryService {

    int addCountry(CountryEntity countryEntity);
    List<CountryEntity> getAllCountries();
    int getCountryId(String name);
}
