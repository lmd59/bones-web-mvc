package org.bones.controller;

import org.bones.dao.UserDAO;
import org.bones.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
         
        return "admin/add-user-result";
    }
    
    @RequestMapping(value="/admin/addUserForm.htm", method=RequestMethod.GET)
    public String addUserForm(Model model) {
         
        return "admin/add-user";
    }
}

