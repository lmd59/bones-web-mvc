package org.bones.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class SecureController {
	
	@RequestMapping(value="/secure/user-profile.htm", method = RequestMethod.GET)
	public String getProfile(ModelMap model) {
 
		System.out.println("Getting current user profile");
        //TODO: get current user profile with DAO
		return "secure/user-profile";
 
	}
	
	
}
