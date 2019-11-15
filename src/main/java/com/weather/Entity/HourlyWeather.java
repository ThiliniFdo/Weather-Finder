/**
 * HourlyWeather entity for handles the list of whether data for 48 hours
 *
 * @version 1.0
 * @author Thilini Fernando
 */

package com.weather.Entity;

import java.util.List;

public class HourlyWeather {
    private String summary;
    private String icon;
    private List<WeatherData> data;

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public List<WeatherData> getData() {
        return data;
    }

    public void setData(List<WeatherData> data) {
        this.data = data;
    }
}
