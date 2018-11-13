package com.PlacesBrowser.Service.FacebookGraphAPI;

import java.util.LinkedList;
import java.util.List;

import javax.inject.Inject;

import com.PlacesBrowser.Domain.RequirementsCompliantPlace;
import com.PlacesBrowser.Domain.Response;

import facebook4j.Place;

/**
 * Parsing service for response from Facebook Graph API.
 * @author MJazy
 *
 */
public class FacebookGraphAPIResponseParser {

	@Inject
	FacebookGraphAPIPlaceValidator facebookGraphAPIPlaceValidator;
	
	public Response parse(List<Place> apiResponse) {
		
		Response response = new Response();
		List<RequirementsCompliantPlace> requirementsCompliantPlaces = new LinkedList<RequirementsCompliantPlace>();
		
		for (Place place: apiResponse) {
			
			if (facebookGraphAPIPlaceValidator.isPlaceValid(place) == true)
			{			
			RequirementsCompliantPlace requirementsCompliantPlace = new RequirementsCompliantPlace();
			requirementsCompliantPlace.setName(place.getName());
			requirementsCompliantPlace.setLatitude(place.getLocation().getLatitude().floatValue());
			requirementsCompliantPlace.setLongitude(place.getLocation().getLongitude().floatValue());
			
			requirementsCompliantPlaces.add(requirementsCompliantPlace);
			}
		}
		
		response.setRequirementsCompliantPlaces(requirementsCompliantPlaces);
		
		return response;
	}

}
