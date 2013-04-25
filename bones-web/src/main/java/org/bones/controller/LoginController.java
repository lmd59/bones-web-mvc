package org.bones.controller;

import java.security.Principal;

import javax.servlet.http.HttpSession;

import org.bones.dao.BonesDAO;
import org.bones.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
 
@Controller
public class LoginController {
	
	@Autowired
	BonesDAO dao;
 
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
	
	@RequestMapping(value="/addUser.htm", method=RequestMethod.POST)
    public String addUser(
    		@RequestParam("username") String username,
    		@RequestParam("password") String password,
    		@RequestParam("firstname") String firstname, 
    		@RequestParam("lastname") String lastname,
    		@RequestParam("nickname") String nickname,
    		@RequestParam("email") String email,
    		@RequestParam("classYear") String classYear,
    		@RequestParam("position") String position,
    		Model model) {
    	
		//Note: no permissions added with create account
        User u = new User();
        u.setUsername(username);
        u.setPassword(password);
        u.setFirstname(firstname);
        u.setLastname(lastname);
        u.setNickname(nickname);
        u.setEmail(email);
        u.setClassYear(classYear);
        u.setPosition(position);
        dao.addUser(u);
        
        
         
        return "login/add-user-result";
    }
    
    @RequestMapping(value="/addUserForm.htm", method=RequestMethod.GET)
    public String addUserForm(Model model) {
         
        return "login/add-user";
    }
 
}