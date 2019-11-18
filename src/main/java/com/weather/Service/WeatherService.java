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
import java.util.Map;

@Service
public class WeatherService {

    @Autowired
    private WeatherDataRepository weatherDataRepository;

    @Autowired
    private DarkskyService darkskyService;

    @Autowired
    private HourlyWeatherService hourlyWeatherService;

    @Autowired
    private DateFormatter dateFormatter;

    /**
     * To get the  weather data
     *
     * @param city
     * @return Weather
     */
    public Weather getData(City city) {
        String day = dateFormatter.getUtcDay(city.getRequestEpoach());
        double latitude = city.getLatitude();
        double longitude = city.getLongitude();
        Weather weather = weatherDataRepository.findByDateLocation(day, latitude, longitude);
        if (weather == null) {
            weather = darkskyService.getDarkskyData(latitude, longitude);
            weather.setDay(dateFormatter.getUtcDay(weather.getCurrently().getTime()));
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
    public void saveData(Weather weather) {
        weatherDataRepository.save(weather);
    }

    /**
     * Get today weather data
     *
     * @param weather
     * @return List of Weather
     */
    public Map<String, List<WeatherData>> getWeatherData(Weather weather, City city) {
        return hourlyWeatherService.getWeatherData(weather.getHourly().getData(), city);
    }

    /**
     * Remove the three days data
     *
     * @param
     * @return
     */
    public void deleteData() {
        LocalDate currentdate = LocalDate.now();
        String currentDay = new Integer(currentdate.getDayOfMonth()).toString();
        List<Weather> expiredData = weatherDataRepository.FindThreeDaysExpiredData(currentDay);
        weatherDataRepository.deleteAll(expiredData);
    }
}
