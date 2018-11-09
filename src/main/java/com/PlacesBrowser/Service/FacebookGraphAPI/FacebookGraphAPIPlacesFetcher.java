package com.PlacesBrowser.Service.FacebookGraphAPI;

import java.util.List;

import javax.inject.Inject;

import com.PlacesBrowser.Service.Interfaces.PlacesFetcherInterface;

import facebook4j.Facebook;
import facebook4j.FacebookException;
import facebook4j.Place;
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
	public List<Place> fetchPlaces(String country, String city, String description) {
		List <Place> places = null;
		try {
			places = facebook.searchPlaces(String.format("%s %s %s", country, city, description), new Reading().fields("location", "name"));
		} catch (FacebookException exception) {
			exception.printStackTrace();
		}
		return places;
	}

}
