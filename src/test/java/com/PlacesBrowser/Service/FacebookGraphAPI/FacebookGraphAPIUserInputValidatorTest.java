package com.PlacesBrowser.Service.FacebookGraphAPI;

import static org.junit.Assert.assertEquals;

import javax.inject.Inject;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FacebookGraphAPIUserInputValidatorTest {

	@Inject
	FacebookGraphAPIUserInputValidator facebookGraphAPIUserInputValidator;
	
	String validCountry, validCity, description;
	
	@Before
	public void initializeVariables() {
		validCountry = "Poland";
		validCity = "Poznan";
		description = "Egnyte";
	}
	
	@Test
	public void invalidCountryTest() {
		assertEquals(false, facebookGraphAPIUserInputValidator.isInputValid(null, validCity, description));
		assertEquals(false, facebookGraphAPIUserInputValidator.isInputValid("", validCity, description));
		assertEquals(false, facebookGraphAPIUserInputValidator.isInputValid(" ", validCity, description));
		assertEquals(false, facebookGraphAPIUserInputValidator.isInputValid("11", validCity, description));

	}
	
	@Test
	public void invalidCityTest() {
		assertEquals(false, facebookGraphAPIUserInputValidator.isInputValid(validCountry, null, description));
		assertEquals(false, facebookGraphAPIUserInputValidator.isInputValid("", validCity, description));
		assertEquals(false, facebookGraphAPIUserInputValidator.isInputValid(validCountry, " ", description));
		
	}
	
	@Test
	public void validInputTest() {
		assertEquals(true, facebookGraphAPIUserInputValidator.isInputValid(validCountry, validCity, description));
	}
	
}
