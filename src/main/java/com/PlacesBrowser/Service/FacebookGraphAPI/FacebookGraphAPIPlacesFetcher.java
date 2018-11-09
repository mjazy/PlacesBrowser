package com.PlacesBrowser.Service.FacebookGraphAPI;

import javax.inject.Inject;

import com.PlacesBrowser.Service.Interfaces.PlacesFetcherInterface;

import facebook4j.Facebook;
import facebook4j.FacebookException;
import facebook4j.Reading;


/**
 * Service enabling fetching data from Facebook Graph API.
 * @author MJazy
 *
 */
public class FacebookGraphAPIPlacesFetcher implements PlacesFetcherInterface {

	@Inject
	Facebook facebook;
	
	/**
	 * 
	 */
	public String fetchPlaces(String country, String city, String description) {
		Object object = null;
		try {
			object = facebook.searchPlaces(String.format("%s %s %s", country, city, description), new Reading().fields("location", "name"));
		} catch (FacebookException exception) {
			exception.printStackTrace();
		}
		return object.toString();
	}

}
