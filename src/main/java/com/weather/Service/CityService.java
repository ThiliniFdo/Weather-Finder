/**
 * CityService service for provides City entity services
 *
 * @version 1.0
 * @author Thilini Fernando
 */
package com.weather.Service;

import com.weather.Entity.City;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@ConfigurationProperties("menu")
public class CityService {
    private List<City> cities;

    public List<City> getCities() {
        return cities;
    }

    public void setCities(List<City> cities) {
        this.cities = cities;
    }


    /**
     * Get the all fields of the given city object
     * @param cityParam
     * @return City
     */
    public City getCity(City cityParam) {
        for (City city : cities) {
            if (city.getTitle().equals(cityParam.getTitle())) {
                return city;
            }
        }
        return null;
    }
}
