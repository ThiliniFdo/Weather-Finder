/**
 * WeatherDataRepositoryCustom interface for custom repository logic
 *
 * @version 1.0
 * @author Thilini Fernando
 */
package com.weather.repositories;

import com.weather.Entity.Weather;

import java.time.LocalDate;

public interface WeatherDataRepositoryCustom {

    /**
     * Query the db based on Date and location
     * @param date
     * @param latitude
     * @param longitude
     * @return
     */
    Weather findByDateLocation(LocalDate date, double latitude, double longitude);
}
