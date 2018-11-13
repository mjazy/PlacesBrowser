package com.PlacesBrowser.Service.FacebookGraphAPI;

import facebook4j.Place;

/**
 * Service validating if place is relevant for response to user.
 * @author MJazy
 *
 */
public class FacebookGraphAPIPlaceValidator {

	/**
	 * Method checking if place is valid.
	 * @param place returned from API.
	 * @return true if name, latitude and longitude are present, false in other case.
	 */
	public boolean isPlaceValid(Place place) {
		
		if (hasName(place) && hasLatitude(place) && hasLongitude(place)) {
			return true;
		}
		
		return false;
	}
	
	/**
	 * Method checking if place has name.
	 * @param place returned from API.
	 * @return true if name is present, false in other case.
	 */
	private boolean hasName(Place place) {
		if (place.getName() == null) {
			return false;
		}
		
		if (place.getName().isBlank() == true) {
			return false;
		}
		
		return true;
	}
	
	/**
	 * Method checking if place has Latitude.
	 * @param place returned from API.
	 * @return true if latitude is present, false in other case.
	 */
	private boolean hasLatitude(Place place) {
		if (place.getLocation().getLatitude() == null) {
			return false;
		}
		
		return true;
	}
	
	/**
	 * Method checking if place has longitude.
	 * @param place returned from API.
	 * @return true if longitude is present, false in other case.
	 */
	private boolean hasLongitude(Place place) {
		if (place.getLocation().getLongitude() == null) {
			return false;
		}
		
		return true;
	}

}
