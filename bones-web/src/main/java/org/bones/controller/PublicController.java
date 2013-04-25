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
	//Controller to direct access for 
	//any publicly accessible pages
	
	private static final Logger logger = LoggerFactory.getLogger(SecureController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "public/home";
	}
		
	/**
	 * Selects view to render by returning its location/name.
	 */
	@RequestMapping(value = "/bones-rock.htm", method = RequestMethod.GET)
	public String bonesRock(Locale locale, Model model) {
		
		return "public/bones-rock";
	}
	
	@RequestMapping(value="/info.htm", method=RequestMethod.GET)
    public String getPublicContent(Model model) {
        return "public/tabbed-content";
    }

}
