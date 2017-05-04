package spring.model.pojo;

import javax.persistence.*;

/**
 * Created by Rage on 03.05.2017.
 */
@Entity
@Table(name = "table_city", schema = "trainschedule")
public class CityEntity {
    private int mCityId;
    private String mCityName;
    private int mCountryId;
    private CountryEntity mCountryEntity;

    @Id
    @Column(name = "city_id",nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getCityId() {
        return mCityId;
    }

    public void setCityId(int cityId) {
        mCityId = cityId;
    }

    @Basic
    @Column(name = "city_name")
    public String getCityName() {
        return mCityName;
    }

    public void setCityName(String cityName) {
        mCityName = cityName;
    }

    @Basic
    @Column(name = "country_id")
    public int getCountryId() {
        return mCountryId;
    }

    public void setCountryId(int countryId) {
        mCountryId = countryId;
    }

    @ManyToOne(optional = false)
    @JoinColumn(name = "country_id", nullable = false,insertable = false,updatable = false)
    public CountryEntity getCountryEntity() {
        return mCountryEntity;
    }

    public void setCountryEntity(CountryEntity countryEntity) {
        mCountryEntity = countryEntity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CityEntity that = (CityEntity) o;

        if (mCityId != that.mCityId) return false;
        if (mCountryId != that.mCountryId) return false;
        if (mCityName != null ? !mCityName.equals(that.mCityName) : that.mCityName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = mCityId;
        result = 31 * result + (mCityName != null ? mCityName.hashCode() : 0);
        result = 31 * result + mCountryId;
        return result;
    }
}
