package spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import spring.model.pojo.CityEntity;
import spring.model.pojo.CountryEntity;
import spring.model.pojo.TripEntity;
import spring.service.CityService;
import spring.service.CountryService;
import spring.service.TripService;
import spring.service.TripServiceImpl;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by Rage on 25.04.2017.
 */
@Controller
public class MainController {

    @Autowired
    private CountryService mCountryService;
    @Autowired
    private CityService mCityService;
    @Autowired
    private TripService mTripService;

    public void setCountryService(CountryService countryService) {
        mCountryService = countryService;
    }

    @RequestMapping(value = "/",method = RequestMethod.GET)
    public String getMain(Map<String, Object> model){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();
        model.put("username",currentPrincipalName);
        if(currentPrincipalName!=null){
            List<CountryEntity> countryEntityList=mCountryService.getAllCountries();
            model.put("countries",countryEntityList);
            List<CityEntity> cityEntityList=mCityService.getAllCity();
            model.put("cities",cityEntityList);
        }
        return "index";
    }
    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public String getSearch(Map<String,Object> model,
                            @RequestParam(value = "departureCity") String departureCity,
                            @RequestParam(value = "arrivalCity")String arrivalCity,
                            @RequestParam(value = "departureCountry")String departureCountry,
                            @RequestParam(value = "arrivalCountry")String arrivalCountry){
        int depCityId=mCityService.getCityId(departureCity);
        int arrCityId=mCityService.getCityId(arrivalCity);
        int depCountry=mCountryService.getCountryId(departureCountry);
        int arrCountry=mCountryService.getCountryId(arrivalCountry);
        model.put("search",mTripService.searchTripEntity(depCityId,arrCityId,depCountry,arrCountry));
        model.put("depCity",departureCity);
        model.put("arrCity",arrivalCity);
        model.put("depCountry",departureCountry);
        model.put("arrCountry",arrivalCountry);
        return getMain(model);
    }
}
