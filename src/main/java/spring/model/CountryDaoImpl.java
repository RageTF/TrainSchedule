package spring.model;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import spring.model.pojo.CityEntity;
import spring.model.pojo.CountryEntity;

import java.util.List;

/**
 * Created by Rage on 03.05.2017.
 */
public class CountryDaoImpl implements CountryDao {

    private SessionFactory mSessionFactory;

    public CountryDaoImpl(SessionFactory sessionFactory) {
        mSessionFactory = sessionFactory;
    }


    @Override
    public int insertCountry(CountryEntity countryEntity) {
        List<CountryEntity> countryEntityList=contain(countryEntity.getCountryName());
        if(countryEntityList==null){
            mSessionFactory.openSession().save(countryEntity);
            return countryEntity.getCountryId();
        }else{
            return countryEntityList.get(0).getCountryId();
        }
    }

    private List<CountryEntity> contain(String country){
        List<CountryEntity> countryEntityList=mSessionFactory.openSession().createQuery("from CountryEntity where countryName=?").setString(0,country).list();
        if(countryEntityList==null || countryEntityList.isEmpty()){
            return null;
        }else{
            return countryEntityList;
        }
    }

    @Override
    public void deleteCountry(int id) {
        Session session=mSessionFactory.openSession();
        CountryEntity countryEntity=session.load(CountryEntity.class,id);
        session.delete(countryEntity);
        session.flush();
    }

    @Override
    public List<CountryEntity> getAllCountries() {
        return mSessionFactory.openSession().createQuery("from CountryEntity ").list();
    }

    @Override
    public int getCountryIdByName(String country) {
        List<CountryEntity> countryEntityList=mSessionFactory.openSession().createQuery("from CountryEntity where countryName=?").setString(0,country).list();
        if(countryEntityList==null || countryEntityList.isEmpty()){
            return -1;
        }
        return countryEntityList.get(0).getCountryId();
    }
}
