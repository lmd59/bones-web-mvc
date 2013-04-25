package org.bones.controller;

import java.security.Principal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpSession;

import org.bones.dao.BonesDAO;
import org.bones.model.Discussion;
import org.bones.model.Message;
import org.bones.model.User;
import org.bones.model.UserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Handles requests for the application home page.
 */
@Controller
public class SecureController {
	
	@Autowired
	BonesDAO dao;
	
	@RequestMapping(value = "/secure/", method = RequestMethod.GET)
	public String home(Model model, Principal principal, HttpSession session) {
		
		//add user to session
		String name = principal.getName();
		User user = dao.getUserByName(name);
		session.setAttribute("user", user);
		
		return "secure/home";
	}
	
	@RequestMapping(value="/secure/user-profile.htm", method = RequestMethod.GET)
	public String getProfile(ModelMap model) {
		return "secure/user-profile";
 
	}
	
	@RequestMapping(value="/secure/discussions.htm", method = RequestMethod.GET)
	public String getDiscussionPage(ModelMap model, HttpSession session) {
		//Get discussions from db
    	List<Discussion> discussionList = dao.getAllDiscussions();
    	
        model.addAttribute("discussions", discussionList);
		
        //get current user messages from db
        List<Message> userMessages = dao.getMessagesForUser(
        		(User)session.getAttribute("user"));
        
        model.addAttribute("userMessages", userMessages);
        
		return "secure/discussions";
 
	}
	
	@RequestMapping(value="/secure/pictures.htm", method = RequestMethod.GET)
	public String getPicturePage(ModelMap model) {
        //TODO: get current user profile with DAO
		return "secure/pictures";
 
	}
	
	@RequestMapping(value="/secure/calendar.htm", method = RequestMethod.GET)
	public String getCalendarPage(ModelMap model) {
        //TODO: get current user profile with DAO
		return "secure/calendar";
 
	}
	
	@RequestMapping(value="/secure/viewDiscussion/{discussionID}", method=RequestMethod.GET)
    public String getDiscussionDetail(Model model, @PathVariable int discussionID) {

		Discussion discussion = dao.getDiscussionByID(discussionID);
		
        //get discussion messages from db
		//(can probably get directly from discussion in jsp with force eager loading)
        List<Message> discussionMessages = dao.getMessagesForDiscussion(discussion);
        
        model.addAttribute("currentDiscussion",discussion);
        model.addAttribute("discussionMessages", discussionMessages);
        
        return "secure/discussionDetail";
    }
	
	@RequestMapping(value="/secure/viewDiscussion/replyDiscussion.htm", method=RequestMethod.POST)
    public String replyDiscussion(Model model, 
    		HttpSession session, 
    		@RequestParam("discussionID") int discussionID,
    		@RequestParam("content") String content,
    		@RequestParam("title") String title) {

		
		Discussion discussion = dao.getDiscussionByID(discussionID);
		
    	Message message = new Message();
    	message.setContent(content);
    	//set date
    	DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
    	message.setCreatedate(dateFormat.format(new Date()));
    	message.setDiscussion(discussion);
    	message.setTitle(title);
    	message.setUser((User)session.getAttribute("user"));
    	dao.addMessage(message);
		
        //get discussion messages from db
		//(can probably get directly from discussion in jsp with force eager loading)
        List<Message> discussionMessages = dao.getMessagesForDiscussion(discussion);
        
        model.addAttribute("currentDiscussion",discussion);
        model.addAttribute("discussionMessages", discussionMessages);
    	
        return ("secure/discussionDetail");
    }
	
	@RequestMapping(value="/secure/createDiscussion.htm", method=RequestMethod.POST)
    public String createDiscussion(Model model, HttpSession session,
    		@RequestParam("title") String title) {

		
		System.out.println("Creating discussion");
		Discussion discussion = new Discussion();
		discussion.setTitle(title);
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
    	discussion.setStartdate(dateFormat.format(new Date()));
		dao.addDiscussion(discussion);
		
    	
		
		List<Discussion> discussionList = dao.getAllDiscussions();
    	
        model.addAttribute("discussions", discussionList);
		
        //get current user messages from db
        List<Message> userMessages = dao.getMessagesForUser(
        		(User)session.getAttribute("user"));
        
        model.addAttribute("userMessages", userMessages);
    	
        return ("secure/discussions");
    }
	
}
