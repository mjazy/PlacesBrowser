package com.PlacesBrowser.Domain;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class PlaceTest {

	Place place;
	String relevantPlaceToStringValue;
	
	@Before
	public void initializeVariables(){
		String testName = "Egnyte Poland";
		float testLatitude = (float) 52.404167557908;
		float testLongitude = (float) 16.940044275923;
		
		place = new Place();
		place.setName(testName);
		place.setLatitude(testLatitude);
		place.setLongitude(testLongitude);
		
		relevantPlaceToStringValue = String.format("name: '%s', latitude: '%s', longitude: '%s'", testName, testLatitude, testLongitude);
	}
	
	@Test
	public void toStringTest() {
		assertEquals(relevantPlaceToStringValue, place.toString());
	}
	
}
