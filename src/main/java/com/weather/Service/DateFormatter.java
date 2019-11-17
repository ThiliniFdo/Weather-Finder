/**
 * DateFormatter class use to format the epoch date
 *
 * @version 1.0
 * @author Thilini Fernando
 */
package com.weather.Service;

import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

@Service
public class DateFormatter {

    /**
     * Get the day from the epoch time
     *
     * @param time
     * @return Day
     */
    public String getUtcDay(long time) {
        LocalDateTime dateTime = LocalDateTime.ofEpochSecond(time, 0, ZoneOffset.UTC);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d");
        return dateTime.format(formatter);
    }

    /**
     * Get the date from the epoch time base on UTC timezone
     *
     * @param time
     * @return Date
     */
    public String getDayByTimeZone(long time, String timeZone) {
        Date date = new Date(time * 1000);
        SimpleDateFormat sdf = new SimpleDateFormat("d", Locale.ENGLISH);
        sdf.setTimeZone(TimeZone.getTimeZone(timeZone));
        return sdf.format(date);
    }
}
