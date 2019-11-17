/**
 * WeatherDataRepositoryCustom interface for custom repository logic
 *
 * @version 1.0
 * @author Thilini Fernando
 */
package com.weather.repositories;

import com.weather.Entity.Weather;

import java.util.List;

public interface WeatherDataRepositoryCustom {

    Weather findByDateLocation(String day, double latitude, double longitude);

    List<Weather> FindThreeDaysExpiredData(String day);
}
