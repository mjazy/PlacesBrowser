package com.PlacesBrowser.Service.FacebookGraphAPI;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertThat;

import java.util.List;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import facebook4j.Place;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FacebookGraphAPIPlacesFetcherTest {
	
	
	@Inject
	FacebookGraphAPIPlacesFetcher facebookGraphAPIPlacesFetcher;	
	
	@Test
	public void fetchPlacesTest() {
		List<Place> fetchPlacesResult = facebookGraphAPIPlacesFetcher.fetchPlaces("poland", "poznan", "Egnyte");
		assertThat(fetchPlacesResult.toString(), containsString("Egnyte Poland"));
		assertThat(fetchPlacesResult.toString(), containsString("52.404719116912"));
		assertThat(fetchPlacesResult.toString(), containsString("16.940510409764"));
	}

}
