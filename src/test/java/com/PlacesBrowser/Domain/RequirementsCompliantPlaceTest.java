package com.PlacesBrowser.Domain;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class RequirementsCompliantPlaceTest {

	RequirementsCompliantPlace requirementsCompliantPlace;
	String relevantRequirementsCompliantPlaceToStringValue;
	
	@Before
	public void initializeVariables(){
		String testName = "Egnyte Poland";
		float testLatitude = (float) 52.404167557908;
		float testLongitude = (float) 16.940044275923;
		
		requirementsCompliantPlace = new RequirementsCompliantPlace();
		requirementsCompliantPlace.setName(testName);
		requirementsCompliantPlace.setLatitude(testLatitude);
		requirementsCompliantPlace.setLongitude(testLongitude);
		
		relevantRequirementsCompliantPlaceToStringValue = String.format("name: '%s', latitude: '%s', longitude: '%s'", testName, testLatitude, testLongitude);
	}
	
	@Test
	public void toStringTest() {
		assertEquals(relevantRequirementsCompliantPlaceToStringValue, requirementsCompliantPlace.toString());
	}
	
}
