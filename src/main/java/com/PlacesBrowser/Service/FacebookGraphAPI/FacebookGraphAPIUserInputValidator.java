package com.PlacesBrowser.Service.FacebookGraphAPI;

import com.PlacesBrowser.Service.Interfaces.UserInputValidatorInterface;

/**
 * Service checking if user input is valid for Facebook Graph API places provider.
 * @author MJazy
 *
 */
public class FacebookGraphAPIUserInputValidator implements UserInputValidatorInterface {

	public boolean isInputValid(String country, String city, String description) {
		if (isCountryValid(country) == false) {
			return false;
		};
		if (isCityValid(city) == false) {
			return false;
		}
		return true;
	}

	/**
	 * Method checking if country is valid.
	 * @param city of which places should be later fetched.
	 * @return false if country is null, blank or contains digit, true in other case.
	 */
	private boolean isCountryValid(String country) {
		if (country == null) {
			return false;
		}
		if (country.isBlank() == true) {
			return false;
		}
		if (containsDigit(country) == true) {
			return false;
		}
		
		return true;
		
	}
	
	/**
	 * Method checking if city is valid.
	 * @param city of which places should be later fetched
	 * @return false if if city is null or blank, true in other case.
	 */
	private boolean isCityValid(String city) {
		if (city == null) {
			return false;
		}
		if (city.isBlank() == true) {
			return false;
		}
		
		return true;
	}
	
	/**
	 * Method checking if supplied string contains digit.
	 * @param string which should be checked.
	 * @return true if there is a digit, false in other case.
	 */
	private boolean containsDigit(String string) {
		for (char character: string.toCharArray()) {
			if (Character.isDigit(character)) {
				return true;
			}
		}
		return false;
	}
	
}
