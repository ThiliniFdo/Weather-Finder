/**
 * Weather document for maintain the collection of weather informations
 *
 * @version 1.0
 * @author Thilini Fernando
 */

package com.weather.Entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotEmpty;

@Document(collection = "weather")
public class Weather {

    @Id
    private String id;
    private String day;
    private double latitude;
    private double longitude;
    private String timezone;
    private CurrentlyWeather currently;
    private HourlyWeather hourly;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public String getTimezone() {
        return timezone;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    public CurrentlyWeather getCurrently() { return currently; }

    public void setCurrently(CurrentlyWeather currently) { this.currently = currently; }

    public HourlyWeather getHourly() {
        return hourly;
    }

    public void setHourly(HourlyWeather hourly) {
        this.hourly = hourly;
    }
}
