package com.PlacesBrowser.REST;

import java.util.List;

import javax.inject.Inject;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.PlacesBrowser.Domain.Response;
import com.PlacesBrowser.Service.FacebookGraphAPI.FacebookGraphAPIPlacesFetcher;
import com.PlacesBrowser.Service.FacebookGraphAPI.FacebookGraphAPIResponseParser;
import com.PlacesBrowser.Service.FacebookGraphAPI.FacebookGraphAPIUserInputValidator;

import facebook4j.Place;

@RestController
public class ApplicationController {

	@Inject
	FacebookGraphAPIUserInputValidator facebookGraphAPIUserInputValidator;
	
	@Inject
	FacebookGraphAPIPlacesFetcher facebookGraphAPIPlacesFetcher;
	
	@Inject
	FacebookGraphAPIResponseParser facebookGraphAPIResponseParser;
	
	
	/**
	 * Endpoint relevant for fetching places.
	 * @param country of which places are sought e.g. Poland.
	 * @param city of which places are sought, can also contain state of particular city if case distinction of same named cities is needed e.g. Poznan.
	 * @param description e.g. cafe.
	 * @return
	 */
	@GetMapping("/{country}/{city}/{description}/")
	Object fetchPlaces(@PathVariable String country, @PathVariable String city, @PathVariable String description) {
		
		if (facebookGraphAPIUserInputValidator.isInputValid(country, city, description) == false) {
			return "Invalid input";
		}
		
		List<Place> apiResponse = facebookGraphAPIPlacesFetcher.fetchPlaces(country, city, description);
		Response response = facebookGraphAPIResponseParser.parse(apiResponse);
		if (response.getRequirementsCompliantPlaces().isEmpty()) {
			return "Places matching provided criteria were not found";
		}
		return response;
	}
	
	
}
