/**
 * City entity handles the defined cities
 *
 * @version 1.0
 * @author Thilini Fernando
 */

package com.weather.Entity;

public class City {
    String title;
    double latitude;
    double longitude;
    long requestEpoach;
    String timeZone;

    public long getRequestEpoach() {
        return requestEpoach;
    }

    public void setRequestEpoach(long requestEpoach) {
        this.requestEpoach = requestEpoach;
    }

    public String getTimeZone() {
        return timeZone;
    }

    public void setTimeZone(String timeZone) {
        this.timeZone = timeZone;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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
}
