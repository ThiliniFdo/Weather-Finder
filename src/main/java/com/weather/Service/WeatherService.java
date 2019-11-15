/**
 * WeatherService service for services of Weather entity
 *
 * @version 1.0
 * @author Thilini Fernando
 */

package com.weather.Service;

import com.weather.Entity.City;
import com.weather.Entity.Weather;
import com.weather.Entity.WeatherData;
import com.weather.repositories.WeatherDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class WeatherService{

    @Autowired
    private WeatherDataRepository weatherDataRepository;

    @Autowired
    private DarkskyService darkskyService;

    @Autowired
    private HourlyWeatherService hourlyWeatherService;

    /**
     * To get the  weather data
     *
     * @param city
     * @return Weather
     */
    public Weather getData(City city){
        if(city == null){
            //TODO: Handle exceptions
            return null;
        }
        LocalDate date = LocalDate.now();
        double latitude = city.getLatitude();
        double longitude = city.getLongitude();
        Weather weather = weatherDataRepository.findByDateLocation(date,latitude,longitude);
        if(weather == null){
            weather = darkskyService.getDarkskyData(latitude,longitude);
            weather.setLatitude(latitude);
            weather.setLongitude(longitude);
            saveData(weather);
        }
        return weather;
    }

    /**
     * save the  weather data
     *
     * @param weather
     * @return
     */
    public void saveData(Weather weather){
        weatherDataRepository.save(weather);
    }

    /**
     * Get today weather data
     *
     * @param weather
     * @return List of Weather
     */
    public List<WeatherData> getToday(Weather weather) {
        return hourlyWeatherService.getTodayData(weather.getHourly().getData());
    }

    /**
     * Get tomorrow weather data
     *
     * @param weather
     * @return List of Weather
     */
    public List<WeatherData> getTomorrow(Weather weather) {
        return hourlyWeatherService.getTomorrowData(weather.getHourly().getData());
    }

    /**
     * Remove the three days data
     *
     * @param
     * @return
     */
    public void deleteData(){
        //TODO: Implement the logic
    }
}
