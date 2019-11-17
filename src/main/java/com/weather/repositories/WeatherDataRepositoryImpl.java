/**
 * WeatherDataRepositoryCustom interface for custom repository logic
 *
 * @version 1.0
 * @author Thilini Fernando
 */
package com.weather.repositories;

import com.weather.Entity.Weather;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.time.LocalDate;


public class WeatherDataRepositoryImpl implements WeatherDataRepositoryCustom {

    @Autowired
    MongoTemplate mongoTemplate;

    /**
     * Query the db based on Date and location
     * @param day
     * @param latitude
     * @param longitude
     * @return
     */
    @Override
    public Weather findByDateLocation(String day, double latitude, double longitude) {
        Query query = new Query();
        query.addCriteria(Criteria.where("day").is(day).and("latitude").is(latitude).and("longitude").is(longitude));
        Weather weather = mongoTemplate.findOne(query, Weather.class);
        return weather;
    }
}
