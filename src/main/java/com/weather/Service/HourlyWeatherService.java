/**
 * HourlyWeatherService service for services of HourlyWeather entity
 *
 * @version 1.0
 * @author Thilini Fernando
 */

package com.weather.Service;

import com.weather.Entity.City;
import com.weather.Entity.WeatherData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class HourlyWeatherService {
    @Autowired
    private DateFormatter dateFormatter;

    /**
     * To get the today and tomorrow weather data
     *
     * @param data
     * @param city
     * @return List of WeatherData
     */
    public Map<String, List<WeatherData>> getWeatherData(List<WeatherData> data, City city) {
        Map<String, List<WeatherData>> weatherData = new HashMap<String, List<WeatherData>>();
        List<WeatherData> today = new ArrayList<WeatherData>();
        List<WeatherData> tomorrow = new ArrayList<WeatherData>();
        int requestedDay;
        int itemDay;

        for (WeatherData item : data) {
            requestedDay = Integer.parseInt(dateFormatter.getDayByTimeZone(city.getRequestEpoach(),city.getTimeZone()));
            itemDay = Integer.parseInt(dateFormatter.getDayByTimeZone(item.getTime(),city.getTimeZone()));
            item.setDate(new Date(item.getTime() * 1000));
            if(itemDay == requestedDay){
                today.add(item);
                weatherData.put("today",today);
            }
            else if(itemDay == requestedDay+1){
                tomorrow.add(item);
                weatherData.put("tomorrow",tomorrow);
            }
        }
        return weatherData;
    }
}
