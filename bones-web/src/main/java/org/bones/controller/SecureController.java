package org.bones.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
	
	@RequestMapping(value="/user-profile.htm", method = RequestMethod.GET)
	public String login(ModelMap model) {
 
		return "secure/user-profile";
 
	}
	
}
