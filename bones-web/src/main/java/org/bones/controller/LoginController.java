package org.bones.controller;

import java.security.Principal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
 
@Controller
public class LoginController {
 
	@RequestMapping(value="/welcome.htm", method = RequestMethod.GET)
	public String printWelcome(ModelMap model, Principal principal ) {
 
		String name = principal.getName();
		model.addAttribute("username", name);
		model.addAttribute("message", "Welcome. " +
				"You have successfully logged in.");
		return "secure/login-welcome";
 
	}
 
	@RequestMapping(value="/login.htm", method = RequestMethod.GET)
	public String login(ModelMap model) {
 
		return "login/login";
 
	}
 
	@RequestMapping(value="/loginfailed.htm", method = RequestMethod.GET)
	public String loginerror(ModelMap model) {
 
		model.addAttribute("error", "true");
		return "login/login";
 
	}
 
	@RequestMapping(value="/logout.htm", method = RequestMethod.GET)
	public String logout(ModelMap model) {
 
		return "login/logged-out";
 
	}
 
}