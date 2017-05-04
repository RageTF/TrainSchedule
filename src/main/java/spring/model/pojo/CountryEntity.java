package spring.model.pojo;

import javax.persistence.*;

/**
 * Created by Rage on 03.05.2017.
 */
@Entity
@Table(name = "table_country", schema = "trainschedule")
public class CountryEntity {
    private int mCountryId;
    private String mCountryName;

    @Id
    @Column(name = "country_id",nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getCountryId() {
        return mCountryId;
    }

    public void setCountryId(int countryId) {
        mCountryId = countryId;
    }

    @Basic
    @Column(name = "country_name")
    public String getCountryName() {
        return mCountryName;
    }

    public void setCountryName(String countryName) {
        mCountryName = countryName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CountryEntity that = (CountryEntity) o;

        if (mCountryId != that.mCountryId) return false;
        if (mCountryName != null ? !mCountryName.equals(that.mCountryName) : that.mCountryName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = mCountryId;
        result = 31 * result + (mCountryName != null ? mCountryName.hashCode() : 0);
        return result;
    }
}
