/**
 * DarkskyService service to communicate with Darksky external api
 *
 * @version 1.0
 * @author Thilini Fernando
 */
package com.weather.Service;

import com.weather.Entity.Weather;
import com.weather.Error.DarkSkyRespondException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

@Service
public class DarkskyService {
    @Autowired
    RestTemplate restTemplate;

    @Value("${darksky.key}")
    private String key;

    /**
     * Call Darksky external api and get the weather information
     * @param latitude
     * @param longitude
     * @return Weather
     */
    public Weather getDarkskyData(double latitude, double longitude) {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<>(headers);
        try{
            Weather weather = restTemplate.exchange("https://api.darksky.net/forecast/" + key + "/" + latitude + "," + longitude, HttpMethod.GET, entity, Weather.class).getBody();
            return weather;
        }catch (RestClientException e){
            throw new DarkSkyRespondException();
        }
    }
}
