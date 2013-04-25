package org.bones.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.bones.model.User;
import org.bones.model.UserRole;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class PublicController {
	//Controller to direct access for any publicly accessible pages
	//Note: doesn't currently do much that's interesting, but could in the future
	
	private static final Logger logger = LoggerFactory.getLogger(SecureController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		
		return "public/home";
	}
	
	@RequestMapping(value="/welcome.htm", method=RequestMethod.GET)
    public String getWelcome(Model model) {
        return "public/welcome";
    }
	
	@RequestMapping(value = "/info.htm", method = RequestMethod.GET)
	public String getInfo(Model model) {
		
		return "public/info";
	}
	
	@RequestMapping(value = "/contacts.htm", method = RequestMethod.GET)
	public String getContacts(Model model) {
		
		return "public/contacts";
	}

}
