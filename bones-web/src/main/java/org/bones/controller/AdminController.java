package org.bones.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.bones.dao.BonesDAO;
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
    BonesDAO dao;
     
    
    
    @RequestMapping(value="/admin/confirmPending/{userID}", method=RequestMethod.GET)
    public String confirmPendingUser(Model model, @PathVariable int userID) {
    	User user = dao.getUserByID(userID);
    	
    	UserRole ur = new UserRole();
    	ur.setAuthority("ROLE_USER");
    	ur.setUser(user);
    	dao.addUserRole(ur);
    	
        return "admin/confirm-role";
    }
    
    @RequestMapping(value="/admin/makeAdmin/{userID}", method=RequestMethod.GET)
    public String makeAdminUser(Model model, @PathVariable int userID) {
    	User user = dao.getUserByID(userID);
    	
    	UserRole ur = new UserRole();
    	ur.setAuthority("ROLE_ADMIN");
    	ur.setUser(user);
    	dao.addUserRole(ur);
    	
        return "admin/confirm-role";
    }
    
    @RequestMapping(value="/admin/listAdmin.htm", method=RequestMethod.GET)
    public String listAdminActions(Model model) {
         
        return "admin/admin-actions";
    }
    
    @RequestMapping(value="/admin/viewAllUsers.htm", method=RequestMethod.GET)
    public String viewAllUsers(Model model) {
    	//Get users from db
    	List<User> userList = dao.getAllUsers();
    	//Create user list categories
    	List<User> pendingUsers = new ArrayList<User>();
    	List<User> basicUsers = new ArrayList<User>();
    	List<User> adminUsers = new ArrayList<User>();
    	//Add users to lists
    	for(User user: userList){
    		Set<UserRole> roles = user.getRoles();
    		if(roles.isEmpty()){
    			pendingUsers.add(user);
    		}else{
    			boolean isAdmin = false;
    			for(UserRole role:roles){
    				//admins only shown in admin list
    				if(role.getAuthority().equals(UserRole.ROLE_ADMIN)){
    					isAdmin = true;
    				}
    			}
    			if(isAdmin){
					adminUsers.add(user);
				}else{
					basicUsers.add(user);
				}
    		}
    	}
    	
        model.addAttribute("pendingUsers", pendingUsers);
        model.addAttribute("basicUsers", basicUsers);
        model.addAttribute("adminUsers", adminUsers);
    	
        return "admin/all-users";
    }
    
}

