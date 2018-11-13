package com.PlacesBrowser.Service;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InjectionPoint;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.PlacesBrowser.Service.FacebookGraphAPI.FacebookGraphAPIPlaceValidator;
import com.PlacesBrowser.Service.FacebookGraphAPI.FacebookGraphAPIPlacesFetcher;
import com.PlacesBrowser.Service.FacebookGraphAPI.FacebookGraphAPIResponseParser;
import com.PlacesBrowser.Service.FacebookGraphAPI.FacebookGraphAPIUserInputValidator;

import facebook4j.Facebook;
import facebook4j.FacebookFactory;
import facebook4j.auth.AccessToken;

@Configuration
public class ServiceConfiguration {

	@Bean
	Facebook facebook() {
		Facebook facebook = FacebookFactory.getSingleton();
		String appId = "815148665482904";
		String appSecret = "9cb81f5b61a80086a659a9a4ff56daab";
		String accessToken = "815148665482904|ZhMaCLtVsvoXfEMYaRKLXwxoJ9Q";
		facebook.setOAuthAppId(appId, appSecret);
		facebook.setOAuthAccessToken(new AccessToken(accessToken, null));
		
		return facebook;
	}
	
	@Bean
	FacebookGraphAPIPlacesFetcher facebookGraphAPIFPLacesFetcher() {
		return new FacebookGraphAPIPlacesFetcher();
	}
	
	@Bean
	FacebookGraphAPIResponseParser facebookGraphAPIResponseParser() {
		return new FacebookGraphAPIResponseParser();
	}
	
	@Bean
	FacebookGraphAPIUserInputValidator facebookGraphAPIUserInputValidator() {
		return new FacebookGraphAPIUserInputValidator();
	}
	
	@Bean
	FacebookGraphAPIPlaceValidator facebookGraphAPIPlaceValidator() {
		return new FacebookGraphAPIPlaceValidator();
	}
	
	@Bean
	@Scope("prototype")
	Logger logger(InjectionPoint injectionPoint) {
		return LoggerFactory.getLogger(injectionPoint.getMember().getDeclaringClass());
	}
		
}
