/**
 * Cleanup the DB by a schedule  job in every night
 *
 * @version 1.0
 * @author Thilini Fernando
 */
package com.weather.Schedule;

import com.weather.Service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;


@Component
public class CleanupSchedule {

    @Autowired
    WeatherService weatherService;
    @Scheduled(cron = "0 0 0 * * ?")
    public void cleanRecords() {
        weatherService.deleteData();
    }
}
