package com.PlacesBrowser.Service.Interfaces;

/**
 * Represents service fetching places from an API.
 * @author MJazy
 *
 */
public interface PlacesFetcherInterface {
	
	/**
	 * Should be used to fetch places from an API.
	 * @param country relevant to sought places e.g. Poland.
	 * @param city relevant to sought places e.g. Poznań.
	 * @param description relevant to sought places e.g. Cafe.
	 * @return response body containing name of the place and it's geographical location.
	 */
	String fetchPlaces(String country, String city, String description);

}
