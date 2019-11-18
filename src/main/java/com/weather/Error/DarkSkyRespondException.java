/**
 * DarkSkyRespondException is to handle the DarkSky exceptions
 *
 * @version 1.0
 * @author Thilini Fernando
 */
package com.weather.Error;

public class DarkSkyRespondException extends RuntimeException {

    public DarkSkyRespondException() {
        super("Weather forecast can't provide, Please try again later");
    }
}
