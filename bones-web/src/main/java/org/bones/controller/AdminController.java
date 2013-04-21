package org.bones.controller;

import org.bones.dao.UserDAO;
import org.bones.model.User;
import org.bones.model.UserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AdminController {
     
    @Autowired
    UserDAO userDao;
     
    @RequestMapping(value="/admin/addUser.htm", method=RequestMethod.POST)
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
    	
        User u = new User();
        u.setUsername(username);
        u.setPassword(password);
        u.setFirstname(firstname);
        u.setLastname(lastname);
        u.setNickname(nickname);
        u.setEmail(email);
        u.setClassYear(classYear);
        u.setPosition(position);
        userDao.addUser(u);
        
        //TODO: select permissions to add, enable user
         
        return "admin/add-user-result";
    }
    
    @RequestMapping(value="/admin/addUserForm.htm", method=RequestMethod.GET)
    public String addUserForm(Model model) {
         
        return "admin/add-user";
    }
    
    @RequestMapping(value="/admin/confirmPending/{userID}", method=RequestMethod.GET)
    public String confirmPendingUser(Model model, @PathVariable int userID) {
    	//TODO: Give users permission and change to enabled
    	User user = userDao.getUserByID(userID);
    	
    	UserRole ur = new UserRole();
    	ur.setAuthority("ROLE_USER");
    	ur.setUser(user);
    	userDao.addUserRole(ur);
    	
        return "admin/confirm-user";
    }
    
    @RequestMapping(value="/admin/listAdmin.htm", method=RequestMethod.GET)
    public String listAdminActions(Model model) {
         
        return "admin/admin-actions";
    }
    
    @RequestMapping(value="/admin/viewAllUsers.htm", method=RequestMethod.GET)
    public String viewAllUsers(Model model) {
    	
        model.addAttribute("pendingUsers", userDao.getPendingUsers()); 
    	
        return "admin/all-users";
    }
    
}

