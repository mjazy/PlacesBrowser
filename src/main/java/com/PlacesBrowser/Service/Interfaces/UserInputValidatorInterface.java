package com.PlacesBrowser.Service.Interfaces;

/**
 * Represents service validating user input.
 * @author MJazy
 *
 */
public interface UserInputValidatorInterface {
	
	/**
	 * Represents method checking if input is valid for relevant places fetcher service.
	 * @param country relevant to sought places e.g. Poland.
	 * @param city relevant to sought places e.g. Poznań.
	 * @param description relevant to sought places e.g. Cafe.
	 * @return true if input is valid, else in other scenario.
	 */
	boolean isInputValid(String country, String city, String description);

}
