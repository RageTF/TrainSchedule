package spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import spring.model.pojo.CityEntity;
import spring.model.pojo.CountryEntity;
import spring.model.pojo.TripEntity;
import spring.service.CityService;
import spring.service.CountryService;
import spring.service.TripService;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by Rage on 04.05.2017.
 */
@Controller
public class AdminController {

    @Autowired
    private TripService mTripService;
    @Autowired
    private CityService mCityService;
    @Autowired
    private CountryService mCountryService;

    @RequestMapping(value = "/admin/addCity", method = RequestMethod.POST)
    public String getCreateCity(@RequestParam(value = "city") String city,
                                @RequestParam(value = "country") String country) {
        CountryEntity countryEntity = new CountryEntity();
        countryEntity.setCountryName(country);
        int countryId = mCountryService.addCountry(countryEntity);
        CityEntity cityEntity = new CityEntity();
        cityEntity.setCityName(city);
        cityEntity.setCountryId(countryId);
        mCityService.addCity(cityEntity);
        return "redirect:/";
    }

    @RequestMapping(value = "/admin/delete",method = RequestMethod.POST)
    public String getDeleteTrip(@RequestParam(value = "tripId")String id){
        mTripService.deleteTrip(Integer.parseInt(id));
        return "redirect:/";
    }

    @RequestMapping(value = "/admin/createTrip", method = RequestMethod.POST)
    public String getCreateTrip(@RequestParam(value = "departureCity") String debCity,
                                @RequestParam(value = "arrivalCity") String arrCity,
                                @RequestParam(value = "departureDay") String depDay,
                                @RequestParam(value = "departureMonth") String depMonth,
                                @RequestParam(value = "departureTime") String depTime,
                                @RequestParam(value = "arrivalDay") String arrDay,
                                @RequestParam(value = "arrivalMonth") String arrMonth,
                                @RequestParam(value = "arrivalTime") String arrTime,
                                @RequestParam(value = "type") String type) {
        TripEntity tripEntity = new TripEntity();
        int debCityId = mCityService.getCityId(debCity);
        int arrCityId = mCityService.getCityId(arrCity);

        Calendar departureTime = Calendar.getInstance();
        Calendar arrivalTime = Calendar.getInstance();
        try {
            departureTime.set(2017, Integer.parseInt(depMonth), Integer.parseInt(depDay)
                    , Integer.parseInt(depTime.substring(0, 2))
                    , Integer.parseInt(depTime.substring(3, 5)));
            arrivalTime.set(2017, Integer.parseInt(arrMonth), Integer.parseInt(arrDay)
                    , Integer.parseInt(arrTime.substring(0, 2))
                    , Integer.parseInt(arrTime.substring(3, 5)));
        } catch (Exception e) {
            return "redirect:/";
        }
        Timestamp departure = new Timestamp(departureTime.getTimeInMillis());
        Timestamp arrival = new Timestamp(arrivalTime.getTimeInMillis());

        if (debCityId != -1 && arrCityId != -1) {
            tripEntity.setTripDeparture(debCityId);
            tripEntity.setTripArrival(arrCityId);
            tripEntity.setTripDepartureTime(departure);
            tripEntity.setTripArrivalTime(arrival);
            tripEntity.setTripType(Integer.parseInt(type));
        }
        mTripService.addTrip(tripEntity);
        return "redirect:/";
    }

}
