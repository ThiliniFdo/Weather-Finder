/**
 * WeatherDataRepository interface for repository
 *
 * @version 1.0
 * @author Thilini Fernando
 */
package com.weather.repositories;

import com.weather.Entity.Weather;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WeatherDataRepository extends MongoRepository<Weather, String >,WeatherDataRepositoryCustom {
}
