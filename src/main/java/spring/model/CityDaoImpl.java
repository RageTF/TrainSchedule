package spring.model;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import spring.model.pojo.CityEntity;

import java.util.List;

/**
 * Created by Rage on 04.05.2017.
 */
public class CityDaoImpl implements CityDao {

    private SessionFactory mSessionFactory;

    public CityDaoImpl(SessionFactory sessionFactory) {
        mSessionFactory = sessionFactory;
    }


    @Override
    public void insertCity(CityEntity cityEntity) {
        if(contain(cityEntity)==null){
            mSessionFactory.openSession().save(cityEntity);
        }
    }

    private List<CityEntity> contain(CityEntity cityEntity){
        List<CityEntity> cityEntityList=mSessionFactory.openSession()
                .createQuery("from CityEntity where cityName=? and countryId=?")
                .setString(0,cityEntity.getCityName())
                .setInteger(1,cityEntity.getCountryId())
                .list();
        if(cityEntityList==null || cityEntityList.isEmpty()){
            return null;
        }else{
            return cityEntityList;
        }
    }

    @Override
    public void deleteCity(int id) {
        Session session=mSessionFactory.openSession();
        CityEntity cityEntity=session.load(CityEntity.class,id);
        session.delete(cityEntity);
        session.flush();
    }

    @Override
    public List<CityEntity> getAllCities() {
        return mSessionFactory.openSession().createQuery("from CityEntity ").list();
    }

    @Override
    public int getCityIdByName(String city) {
        List<CityEntity> cityEntityList=mSessionFactory.openSession().createQuery("from CityEntity  where cityName=?").setString(0,city).list();
        if(cityEntityList==null || cityEntityList.isEmpty()){
            return -1;
        }
        return cityEntityList.get(0).getCityId();
    }

    public static void main(String[] args) {
        System.out.println(getDuration(28800000));
    }

    private static String getDuration(long milliseconds) {
        int minutes = (int) ((milliseconds / (1000 * 60)) % 60);
        int hours = (int) ((milliseconds / (1000 * 60 * 60)) % 24);
        StringBuilder stringBuilder = new StringBuilder();
        if (hours != 0) {
            stringBuilder.append(hours);
            stringBuilder.append(" ");
            stringBuilder.append("ч");
            stringBuilder.append(" ");
        }
        if(minutes<10){
            stringBuilder.append("0");
        }
        stringBuilder.append(minutes);
        stringBuilder.append(" ");
        stringBuilder.append("мин");

        return stringBuilder.toString();
    }
}
