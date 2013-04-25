package org.bones.controller;


import java.util.Locale;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class SecureController {
	
	@RequestMapping(value = "/secure/", method = RequestMethod.GET)
	public String home(Model model) {
		
		return "secure/home";
	}
	
	@RequestMapping(value="/secure/user-profile.htm", method = RequestMethod.GET)
	public String getProfile(ModelMap model) {
 
		System.out.println("Getting current user profile");
        //TODO: get current user profile with DAO
		return "secure/user-profile";
 
	}
	
	
}
