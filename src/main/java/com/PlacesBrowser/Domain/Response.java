package com.PlacesBrowser.Domain;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Data model for response to be returned in case of GET related to fetching places.
 * @author MJazy
 *
 */
public class Response {
	
	@JsonProperty
	private List<Place> places;

	public List<Place> getPlaces() {
		return places;
	}

	public void setPlaces(List<Place> places) {
		this.places = places;
	}

}
