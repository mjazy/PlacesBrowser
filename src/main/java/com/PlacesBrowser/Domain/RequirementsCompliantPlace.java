package com.PlacesBrowser.Domain;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Data model for place in format compliant with requirements.
 * @author MJazy
 *
 */
public class RequirementsCompliantPlace {

	@JsonProperty
	private String name;
	
	@JsonProperty
	private float latitude;
	
	@JsonProperty
	private float longitude;
	
	public RequirementsCompliantPlace() {
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}	

	public float getLatitude() {
		return latitude;
	}
	
	public void setLatitude(float latitude) {
		this.latitude = latitude;
	}
	
	public float getLongitude() {
		return longitude;
	}
	
	public void setLongitude(float longitude) {
		this.longitude = longitude;
	}
	
	@Override
	public String toString() {
		String string = String.format("name: '%s', latitude: '%s', longitude: '%s'", this.getName(), this.getLatitude(), this.getLongitude());
		return string;
	}
	
	
}
