import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import spring.model.pojo.CityEntity;
import spring.model.pojo.CountryEntity;
import spring.service.CityService;
import spring.service.CountryService;
import static junit.framework.TestCase.*;

/**
 * Created by Rage on 14.05.2017.
 */
@RunWith(MockitoJUnitRunner.class)
public class Test {

    @Mock
    private CountryService mCountryService;
    @Mock
    private CityService mCityService;

    @org.junit.Test
    public void testCountryService(){
        CountryEntity countryEntity=new CountryEntity();
        countryEntity.setCountryName("Test1");
        mCountryService.addCountry(countryEntity);
        int id=mCountryService.getCountryId("Test1");
        assertEquals(true,id>-1);
    }

    @org.junit.Test
    public void testCityService(){
        CountryEntity countryEntity=new CountryEntity();
        countryEntity.setCountryName("Russia1");
        mCountryService.addCountry(countryEntity);

        CityEntity cityEntity=new CityEntity();
        cityEntity.setCityName("Kazan1");
        cityEntity.setCountryId(mCountryService.getCountryId("Russia1"));
        mCityService.addCity(cityEntity);

        int id=mCityService.getCityId("Kazan1");
        assertEquals(true, id>-1);
    }

}
