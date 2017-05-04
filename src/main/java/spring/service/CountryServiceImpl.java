package spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import spring.model.CountryDao;
import spring.model.pojo.CountryEntity;

import java.util.List;

/**
 * Created by Rage on 04.05.2017.
 */
public class CountryServiceImpl implements CountryService{

    private CountryDao mCountryDao;

    public CountryServiceImpl(CountryDao countryDao) {
        mCountryDao = countryDao;
    }

    @Override
    @Transactional
    public int addCountry(CountryEntity countryEntity) {
        return mCountryDao.insertCountry(countryEntity);
    }

    @Override
    public List<CountryEntity> getAllCountries() {
        return mCountryDao.getAllCountries();
    }

    @Override
    public int getCountryId(String name) {
        return mCountryDao.getCountryIdByName(name);
    }
}
