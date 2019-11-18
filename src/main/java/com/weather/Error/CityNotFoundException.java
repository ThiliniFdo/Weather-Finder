/**
 * CityNotFoundException is to generated the City Not found exception custom message
 *
 * @version 1.0
 * @author Thilini Fernando
 */

package com.weather.Error;

public class CityNotFoundException  extends RuntimeException {
    public CityNotFoundException() {
        super( " City is not found, Please goto above page and select a valid city");
    }

}