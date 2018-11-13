package com.PlacesBrowser.Service.FacebookGraphAPI;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import javax.inject.Inject;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import facebook4j.Place;
import facebook4j.Place.Location;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FacebookGraphAPIPlaceValidatorTest {

	@Inject
	FacebookGraphAPIPlaceValidator facebookGraphAPIPlaceValidator;
	
	Place validPlace, invalidPlace, invalidPlace1, invalidPlace2;
	
	@Before
	public void mockVariables() {
		String testString = "test";
		Double testDouble = 1.1;

		validPlace = mockPlace(validPlace, testString, testDouble, testDouble);
		invalidPlace = mockPlace(invalidPlace, null, testDouble, testDouble);
		invalidPlace1 = mockPlace(invalidPlace1, testString, null, testDouble);
		invalidPlace2 = mockPlace(invalidPlace2, testString, testDouble, null);
		
		

	}
	
	@Test
	public void validMockPlaceTest() {
		assertEquals(true, facebookGraphAPIPlaceValidator.isPlaceValid(validPlace));
	}
	
	@Test
	public void invalidMockPlaceTest() {
		assertEquals(false, facebookGraphAPIPlaceValidator.isPlaceValid(invalidPlace));
		assertEquals(false, facebookGraphAPIPlaceValidator.isPlaceValid(invalidPlace1));
		assertEquals(false, facebookGraphAPIPlaceValidator.isPlaceValid(invalidPlace2));		
	}
	
	private Place mockPlace(Place place, String name, Double latitude, Double longitude) {
		place = mock(Place.class);
		when(place.getName()).thenReturn(name);
		Location location = mock(Location.class);
		when(location.getLatitude()).thenReturn(latitude);
		when(location.getLongitude()).thenReturn(longitude);
		when(place.getLocation()).thenReturn(location);

		return place;
	}
	
}
