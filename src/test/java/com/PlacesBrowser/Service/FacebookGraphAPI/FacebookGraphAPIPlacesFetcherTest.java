package com.PlacesBrowser.Service.FacebookGraphAPI;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertThat;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FacebookGraphAPIPlacesFetcherTest {
	
	
	@Inject
	FacebookGraphAPIPlacesFetcher facebookGraphAPIPlacesFetcher;	
	
	@Test
	public void fetchPlacesTest() {
		String fetchPlacesResult = facebookGraphAPIPlacesFetcher.fetchPlaces("poland", "poznan", "Egnyte");
		assertThat(fetchPlacesResult, containsString("Egnyte Poland"));
		assertThat(fetchPlacesResult, containsString("52.404719116912"));
		assertThat(fetchPlacesResult, containsString("16.940510409764"));
	}

}
