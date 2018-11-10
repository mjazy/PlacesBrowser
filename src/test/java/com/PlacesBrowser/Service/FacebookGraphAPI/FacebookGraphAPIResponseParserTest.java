package com.PlacesBrowser.Service.FacebookGraphAPI;

import static org.junit.Assert.assertEquals;
import java.util.List;

import javax.inject.Inject;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.PlacesBrowser.Domain.RequirementsCompliantPlace;
import com.PlacesBrowser.Domain.Response;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FacebookGraphAPIResponseParserTest {

	@Inject
	FacebookGraphAPIPlacesFetcher facebookGraphAPIPlacesFetcher;
	
	@Inject
	FacebookGraphAPIResponseParser facebookGraphAPIResponseParser;	

	
	Response response;
	String expectedName;
	float expectedLatitude, expectedLongitude;
	
	@Before
	public void initializeVariables() {
		expectedName = "Egnyte Poland";
		expectedLatitude = (float)52.40472;
		expectedLongitude = (float)16.94051;
		
		List<facebook4j.Place> apiResponse;
		
		apiResponse = facebookGraphAPIPlacesFetcher.fetchPlaces("Poland", "Poznań", "Egnyte");
		response = facebookGraphAPIResponseParser.parse(apiResponse);		
	}
	
	@Test
	public void isResponseCorrect() {
		
		boolean containsExpectedValues = false;
		
		List<RequirementsCompliantPlace> requirementsCompliantPlaces = response.getRequirementsCompliantPlaces();
		
		for (RequirementsCompliantPlace requirementsCompliantPlace: requirementsCompliantPlaces) {
			if (doesRequirementsCompliantPlaceContainExpectedValues(requirementsCompliantPlace) == true) {
				containsExpectedValues = true;
			}
		}
		
		assertEquals(true, containsExpectedValues);
		
	}
	
	
	public boolean doesRequirementsCompliantPlaceContainExpectedValues(RequirementsCompliantPlace requirementsCompliantPlace) {
		if (requirementsCompliantPlace.getName().equals(expectedName) != true) {
			return false;
		}
		if (requirementsCompliantPlace.getLatitude() != expectedLatitude) {
			return false;
		}
		if (requirementsCompliantPlace.getLongitude() != expectedLongitude) {
			return false;
		}
		return true;
		
	}
	
	
	
}
