package com.PlacesBrowser.REST;

import static org.assertj.core.api.Assertions.assertThat;
import javax.inject.Inject;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import com.PlacesBrowser.Domain.Response;



@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class ApplicationControllerTest {

	
	@LocalServerPort
	private int port;
	
	@Inject
	RestTemplate restTemplate;
	
	private String validFetchPlacesPath, invalidUserParametersPath, noPlacesFoundPath;
	
	@Before
	public void initializeVariables() {
		validFetchPlacesPath = String.format("http://localhost:%s/Poland/Poznan/Egnyte/", port);
		invalidUserParametersPath = String.format("http://localhost:%s/%%20/Poznan/Egnyte/", port);
		noPlacesFoundPath = String.format("http://localhost:%s/test/Poznan/Egnyte/", port);
	}
	
	@Test
	public void validFetchPlacesRun() {
		assertThat(this.restTemplate.getForObject(validFetchPlacesPath, Response.class).getRequirementsCompliantPlaces().toString()).contains("Egnyte Poland");
		
	}
	

	@Test
	public void invalidUserParametersRun() {
		assertThat(this.restTemplate.getForObject(invalidUserParametersPath, String.class)).contains("Invalid input");
		
	}


	@Test
	public void noPlacesFoundRun() {
		assertThat(this.restTemplate.getForObject(noPlacesFoundPath, String.class)).contains("Places matching provided criteria were not found");
		
	}

	
	
	
}
