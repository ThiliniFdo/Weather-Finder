/**
 * HourlyWeatherService service for services of HourlyWeather entity
 *
 * @version 1.0
 * @author Thilini Fernando
 */

package com.weather.Service;

import com.weather.Entity.WeatherData;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class HourlyWeatherService {

    public static long dayDiff(long time, int field) {
        long fieldTime = getFieldInMillis(field);
        Calendar cal = Calendar.getInstance();
        long now = cal.getTimeInMillis();
        return (time / fieldTime - now / fieldTime);
    }

    private static final long getFieldInMillis(int field) {
        final Calendar cal = Calendar.getInstance();
        long now = cal.getTimeInMillis();
        cal.add(field, 1);
        long after = cal.getTimeInMillis();
        return after - now;
    }

    /**
     * To get the today weather data
     *
     * @param data
     * @return List of WeatherData
     */
    public List<WeatherData> getTodayData(List<WeatherData> data) {
        List<WeatherData> weatherData = new ArrayList<>();
        data.forEach(item -> {
            if (dayDiff(item.getTime() * 1000, Calendar.DAY_OF_YEAR) == 0) {
                item.setDate(new Date(item.getTime() * 1000));
                weatherData.add(item);
            }
        });
        return weatherData;
    }

    /**
     * To get the tomorrow weather data
     *
     * @param data
     * @return List of WeatherData
     */
    public List<WeatherData> getTomorrowData(List<WeatherData> data) {
        List<WeatherData> weatherData = new ArrayList<>();
        data.forEach(item -> {
            if (dayDiff(item.getTime() * 1000, Calendar.DAY_OF_YEAR + 1) == 1) {
                item.setDate(new Date(item.getTime() * 1000));
                weatherData.add(item);
            }
        });
        return weatherData;
    }
}
