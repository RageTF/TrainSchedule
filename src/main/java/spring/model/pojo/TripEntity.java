package spring.model.pojo;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by Rage on 03.05.2017.
 */
@Entity
@Table(name = "table_trip", schema = "trainschedule")
public class TripEntity {
    private int mTripId;
    private int mTripDeparture;
    private int mTripArrival;
    private Timestamp mTripDepartureTime;
    private Timestamp mTripArrivalTime;
    private int mTripType;

    private CityEntity mTableCityDepartureEntity;
    private CityEntity mTableCityArrivalEntity;

    @Id
    @Column(name = "trip_id",nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getTripId() {
        return mTripId;
    }

    public void setTripId(int tripId) {
        mTripId = tripId;
    }

    @Basic
    @Column(name = "trip_departure")
    public int getTripDeparture() {
        return mTripDeparture;
    }

    public void setTripDeparture(int tripDeparture) {
        mTripDeparture = tripDeparture;
    }

    @Basic
    @Column(name = "trip_arrival")
    public int getTripArrival() {
        return mTripArrival;
    }

    public void setTripArrival(int tripArrival) {
        mTripArrival = tripArrival;
    }

    @Basic
    @Column(name = "trip_departure_time")
    public Timestamp getTripDepartureTime() {
        return mTripDepartureTime;
    }

    public void setTripDepartureTime(Timestamp tripDepartureTime) {
        mTripDepartureTime = tripDepartureTime;
    }

    @Basic
    @Column(name = "trip_arrival_time")
    public Timestamp getTripArrivalTime() {
        return mTripArrivalTime;
    }

    public void setTripArrivalTime(Timestamp tripArrivalTime) {
        mTripArrivalTime = tripArrivalTime;
    }

    @Basic
    @Column(name = "trip_type")
    public int getTripType() {
        return mTripType;
    }

    public void setTripType(int tripType) {
        mTripType = tripType;
    }

    @ManyToOne(optional = false)
    @JoinColumn(name = "trip_departure", nullable = false,insertable = false,updatable = false)
    public CityEntity getTableCityDepartureEntity() {
        return mTableCityDepartureEntity;
    }

    public void setTableCityDepartureEntity(CityEntity tableCityDepartureEntity) {
        mTableCityDepartureEntity = tableCityDepartureEntity;
    }

    @ManyToOne(optional = false)
    @JoinColumn(name = "trip_arrival", nullable = false,insertable = false,updatable = false)
    public CityEntity getTableCityArrivalEntity() {
        return mTableCityArrivalEntity;
    }

    public void setTableCityArrivalEntity(CityEntity tableCityArrivalEntity) {
        mTableCityArrivalEntity = tableCityArrivalEntity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TripEntity that = (TripEntity) o;

        if (mTripId != that.mTripId) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = mTripId;
        result = 31 * result + mTripDeparture;
        result = 31 * result + mTripArrival;
        result = 31 * result + (mTripDepartureTime != null ? mTripDepartureTime.hashCode() : 0);
        result = 31 * result + (mTripArrivalTime != null ? mTripArrivalTime.hashCode() : 0);
        result = 31 * result + mTripType;
        return result;
    }
}
