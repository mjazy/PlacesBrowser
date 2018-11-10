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
	private List<RequirementsCompliantPlace> requirementsCompliantPlaces;

	public List<RequirementsCompliantPlace> getRequirementsCompliantPlaces() {
		return requirementsCompliantPlaces;
	}

	public void setRequirementsCompliantPlaces(List<RequirementsCompliantPlace> requirementsCompliantPlaces) {
		this.requirementsCompliantPlaces = requirementsCompliantPlaces;
	}

}
